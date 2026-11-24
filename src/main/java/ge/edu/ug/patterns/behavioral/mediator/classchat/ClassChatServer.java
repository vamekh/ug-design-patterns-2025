package ge.edu.ug.patterns.behavioral.mediator.classchat;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// A tiny HTTP front for ClassChat, built on the JDK's own HTTP server (no dependencies).
//
//   POST /register?name=Giorgi     registers the caller's IP address as "Giorgi"
//   POST /message?text=Hello       posts a message (the text can also be sent as the request body)
//
// Run ClassChatServer.main() from the IDE (optional argument: port, default 8080).
// Students run ClassChatClient with the server's address, or use curl:
//   curl -X POST "http://<server-ip>:8080/register?name=Giorgi"
//   curl -X POST "http://<server-ip>:8080/message" --data "Hello class"
public class ClassChatServer {
    public static final int DEFAULT_PORT = 8080;
    public static final String LOOPBACK_IP = "127.0.0.1";
    private static final int MAX_BODY_BYTES = 4096;

    private final ClassChat chat;
    private final HttpServer server;

    public ClassChatServer(ClassChat chat, int port) throws IOException {
        this.chat = chat;
        this.server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/register", this::handleRegister);
        server.createContext("/message", this::handleMessage);
        server.createContext("/", this::handleUnknownPath);
    }

    public void start() {
        server.start();
    }

    public void stop() {
        server.stop(0);
    }

    public int getPort() {
        return server.getAddress().getPort();
    }

    private void handleRegister(HttpExchange exchange) throws IOException {
        if (!isPost(exchange)) {
            return;
        }
        String name = queryParams(exchange).get("name");
        if (name == null || name.isBlank()) {
            warnIfUnknown(exchange, "tried to register without a name");
            respond(exchange, 400, "Missing name, use /register?name=YourName");
            return;
        }
        try {
            String registered = chat.register(ip(exchange), name);
            respond(exchange, 200, "Welcome, " + registered + "!");
        } catch (IllegalArgumentException e) {
            respond(exchange, 400, e.getMessage());
        }
    }

    private void handleMessage(HttpExchange exchange) throws IOException {
        if (!isPost(exchange)) {
            return;
        }
        String text = queryParams(exchange).get("text");
        if (text == null) {
            text = readBody(exchange);
        }
        try {
            chat.post(ip(exchange), text); // warns by itself when the IP is unknown
            respond(exchange, 200, "Sent");
        } catch (IllegalStateException e) {
            respond(exchange, 403, "Register first: POST /register?name=YourName");
        } catch (IllegalArgumentException e) {
            respond(exchange, 400, e.getMessage());
        }
    }

    private void handleUnknownPath(HttpExchange exchange) throws IOException {
        warnIfUnknown(exchange, "requested an unknown path");
        respond(exchange, 404, "Unknown endpoint. Use POST /register?name=YourName and POST /message");
    }

    private boolean isPost(HttpExchange exchange) throws IOException {
        if (exchange.getRequestMethod().equalsIgnoreCase("POST")) {
            return true;
        }
        warnIfUnknown(exchange, "used " + exchange.getRequestMethod() + " instead of POST");
        exchange.getResponseHeaders().set("Allow", "POST");
        respond(exchange, 405, "Use POST");
        return false;
    }

    // Anyone who has not registered yet is a stranger: print a warning on the server console
    private void warnIfUnknown(HttpExchange exchange, String what) {
        String ip = ip(exchange);
        if (chat.nameOf(ip).isEmpty()) {
            chat.warn("unknown IP " + ip + " " + what + ": "
                    + exchange.getRequestMethod() + " " + exchange.getRequestURI().getRawPath());
        }
    }

    // The caller's IP; this machine is always 127.0.0.1, whether it connected over IPv4 or IPv6
    private static String ip(HttpExchange exchange) {
        InetAddress address = exchange.getRemoteAddress().getAddress();
        return address.isLoopbackAddress() ? LOOPBACK_IP : address.getHostAddress();
    }

    private static Map<String, String> queryParams(HttpExchange exchange) {
        String query = exchange.getRequestURI().getRawQuery();
        if (query == null || query.isEmpty()) {
            return Collections.emptyMap();
        }
        Map<String, String> params = new HashMap<>();
        for (String pair : query.split("&")) {
            int eq = pair.indexOf('=');
            String key = eq < 0 ? pair : pair.substring(0, eq);
            String value = eq < 0 ? "" : pair.substring(eq + 1);
            params.put(URLDecoder.decode(key, StandardCharsets.UTF_8), URLDecoder.decode(value, StandardCharsets.UTF_8));
        }
        return params;
    }

    private static String readBody(HttpExchange exchange) throws IOException {
        try (InputStream in = exchange.getRequestBody()) {
            byte[] body = in.readNBytes(MAX_BODY_BYTES);
            return new String(body, StandardCharsets.UTF_8);
        }
    }

    private static void respond(HttpExchange exchange, int status, String text) throws IOException {
        byte[] bytes = (text + "\n").getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().set("Content-Type", "text/plain; charset=utf-8");
        exchange.sendResponseHeaders(status, bytes.length);
        try (OutputStream out = exchange.getResponseBody()) {
            out.write(bytes);
        }
    }

    // The address students on the same network use to reach this machine:
    // the one the router gave it, so VPN, Docker and other virtual adapters are left out.
    public static List<String> localAddresses() throws IOException {
        Optional<String> fromRouter = routerAssignedAddress();
        if (fromRouter.isPresent()) {
            return List.of(fromRouter.get());
        }
        // No route to the router found: fall back to private LAN addresses (192.168.x.x, 10.x.x.x, 172.16-31.x.x)
        List<String> addresses = new ArrayList<>();
        for (NetworkInterface nic : Collections.list(NetworkInterface.getNetworkInterfaces())) {
            if (!nic.isUp() || nic.isLoopback() || nic.isVirtual()) {
                continue;
            }
            for (InetAddress address : Collections.list(nic.getInetAddresses())) {
                if (address instanceof Inet4Address && address.isSiteLocalAddress()) {
                    addresses.add(address.getHostAddress());
                }
            }
        }
        if (addresses.isEmpty()) {
            addresses.add(LOOPBACK_IP); // no network: only this machine can connect
        }
        return addresses;
    }

    // Asks the operating system which local address it would use to send a packet out through the router.
    // Connecting a UDP socket only picks a route; no packet is sent, so this works without internet access.
    static Optional<String> routerAssignedAddress() {
        try (DatagramSocket socket = new DatagramSocket()) {
            socket.connect(InetAddress.getByName("8.8.8.8"), 53);
            InetAddress local = socket.getLocalAddress();
            if (local instanceof Inet4Address && !local.isAnyLocalAddress() && !local.isLoopbackAddress()) {
                return Optional.of(local.getHostAddress());
            }
        } catch (IOException | RuntimeException e) {
            // no network route: the caller falls back to scanning the interfaces
        }
        return Optional.empty();
    }

    // What the server prints on start: its addresses and how to use each endpoint
    public static List<String> startupBanner(int port, List<String> addresses) {
        List<String> lines = new ArrayList<>();
        lines.add("Class chat server is running on port " + port);
        for (String address : addresses) {
            String base = "http://" + address + ":" + port;
            lines.add("");
            lines.add(address.equals(LOOPBACK_IP)
                    ? "No network found, only this computer can connect: " + base
                    : "Others on this network connect to: " + base);
            lines.add("  Register a user: POST " + base + "/register?name=YourName");
            lines.add("  Send a message:  POST " + base + "/message   (text in the body or ?text=...)");
            lines.add("  curl -X POST \"" + base + "/register?name=YourName\"");
            lines.add("  curl -X POST \"" + base + "/message\" --data \"Hello class\"");
            lines.add("  Console client:  ClassChatClient " + base);
        }
        lines.add("");
        lines.add("Waiting for messages...");
        return lines;
    }

    public static void main(String[] args) throws IOException {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;
        ClassChatServer server = new ClassChatServer(new ClassChat(), port);
        server.start();
        startupBanner(server.getPort(), localAddresses()).forEach(System.out::println);
    }
}

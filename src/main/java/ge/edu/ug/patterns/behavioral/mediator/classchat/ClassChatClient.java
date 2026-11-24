package ge.edu.ug.patterns.behavioral.mediator.classchat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

// Console client for ClassChatServer.
// The first line typed is the user's name, every line after that is a message.
// Stops at the end of input (Ctrl+D, or Ctrl+Z then Enter on Windows) or on "/quit".
//
// Run it with the server's address, e.g.  ClassChatClient http://192.168.1.10:8080
public class ClassChatClient {
    public static final String DEFAULT_SERVER = "http://" + ClassChatServer.LOOPBACK_IP + ":" + ClassChatServer.DEFAULT_PORT;
    public static final String QUIT = "/quit";

    private final HttpClient http = HttpClient.newHttpClient();
    private final String serverUrl;
    private final PrintStream out;

    public ClassChatClient(String serverUrl, PrintStream out) {
        this.serverUrl = serverUrl.endsWith("/") ? serverUrl.substring(0, serverUrl.length() - 1) : serverUrl;
        this.out = out;
    }

    public void run(Scanner scanner) {
        boolean registered = false;
        out.println("Connected to " + serverUrl + ". Type your name:");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            if (line.equals(QUIT)) {
                break;
            }
            if (!registered) {
                registered = register(line);
                if (registered) {
                    out.println("Type your messages, " + QUIT + " to leave:");
                } else {
                    out.println("Type your name again:");
                }
            } else {
                send(line);
            }
        }
        out.println("Bye!");
    }

    public boolean register(String name) {
        return post("/register?name=" + URLEncoder.encode(name, StandardCharsets.UTF_8), "");
    }

    public boolean send(String message) {
        return post("/message", message);
    }

    // Prints the server's answer; true when the server accepted the request
    private boolean post(String pathAndQuery, String body) {
        HttpRequest request = HttpRequest.newBuilder(URI.create(serverUrl + pathAndQuery))
                .header("Content-Type", "text/plain; charset=utf-8")
                .POST(HttpRequest.BodyPublishers.ofString(body, StandardCharsets.UTF_8))
                .build();
        try {
            HttpResponse<String> response = http.send(request, HttpResponse.BodyHandlers.ofString());
            boolean ok = response.statusCode() == 200;
            if (!ok || pathAndQuery.startsWith("/register")) {
                out.println("Server: " + response.body().trim());
            }
            return ok;
        } catch (IOException e) {
            out.println("Cannot reach " + serverUrl + ": " + e.getMessage());
            return false;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public static void main(String[] args) {
        String server = args.length > 0 ? args[0] : DEFAULT_SERVER;
        new ClassChatClient(server, System.out).run(new Scanner(System.in, StandardCharsets.UTF_8));
    }
}

package ge.edu.ug.patterns.behavioral.mediator.classchat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClassChatServerTest {

    private final ByteArrayOutputStream printed = new ByteArrayOutputStream();
    private final ClassChat chat = new ClassChat(new PrintStream(printed, true, StandardCharsets.UTF_8));
    private final HttpClient client = HttpClient.newHttpClient();
    private ClassChatServer server;

    @BeforeEach
    void startServer() throws Exception {
        server = new ClassChatServer(chat, 0); // 0 = any free port
        server.start();
    }

    @AfterEach
    void stopServer() {
        server.stop();
    }

    private HttpResponse<String> post(String pathAndQuery, String body) throws Exception {
        HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:" + server.getPort() + pathAndQuery))
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    private static String encode(String text) {
        return URLEncoder.encode(text, StandardCharsets.UTF_8);
    }

    @Test
    void registeredUserCanChat() throws Exception {
        HttpResponse<String> registered = post("/register?name=" + encode("Giorgi"), "");
        assertEquals(200, registered.statusCode());
        assertEquals("Welcome, Giorgi!\n", registered.body());

        assertEquals(200, post("/message?text=" + encode("Hello class!"), "").statusCode());
        assertEquals(200, post("/message", "Text in the body works too").statusCode());

        List<String> history = chat.getHistory();
        assertTrue(history.get(0).startsWith("*** Giorgi joined from "));
        assertEquals("Giorgi: Hello class!", history.get(1));
        assertEquals("Giorgi: Text in the body works too", history.get(2));
        assertTrue(printed.toString(StandardCharsets.UTF_8).contains("Giorgi: Hello class!"));
    }

    @Test
    void messageBeforeRegisteringIsRefused() throws Exception {
        HttpResponse<String> response = post("/message?text=hi", "");
        assertEquals(403, response.statusCode());
        assertTrue(chat.getHistory().isEmpty());
    }

    @Test
    void unknownIpIsWarnedAbout() throws Exception {
        post("/message?text=hi", "");
        post("/admin", "");

        List<String> warnings = chat.getWarnings();
        assertEquals(2, warnings.size());
        assertTrue(warnings.get(0).contains("unknown IP 127.0.0.1 sent a message without registering: \"hi\""), warnings.get(0));
        assertTrue(warnings.get(1).contains("unknown IP 127.0.0.1 requested an unknown path: POST /admin"), warnings.get(1));
        String console = printed.toString(StandardCharsets.UTF_8);
        assertTrue(console.contains("⚠ WARNING: unknown IP 127.0.0.1"));
        // warnings are not chat lines
        assertTrue(chat.getHistory().isEmpty());
    }

    @Test
    void registeredUserIsNotWarnedAbout() throws Exception {
        post("/register?name=Giorgi", "");
        post("/message?text=hi", "");
        assertEquals(404, post("/typo", "").statusCode());

        assertTrue(chat.getWarnings().isEmpty());
    }

    @Test
    void startupBannerShowsEveryAddressWithBothEndpoints() {
        List<String> banner = ClassChatServer.startupBanner(8080, List.of("192.168.1.10", "10.0.0.2"));
        String text = String.join("\n", banner);

        assertTrue(text.contains("Others on this network connect to: http://192.168.1.10:8080"));
        assertTrue(text.contains("POST http://192.168.1.10:8080/register?name=YourName"));
        assertTrue(text.contains("POST http://192.168.1.10:8080/message"));
        assertTrue(text.contains("curl -X POST \"http://10.0.0.2:8080/message\" --data \"Hello class\""));
        assertTrue(text.contains("ClassChatClient http://10.0.0.2:8080"));
    }

    @Test
    void startupBannerSaysWhenOnlyThisComputerCanConnect() {
        String text = String.join("\n", ClassChatServer.startupBanner(8080, List.of(ClassChatServer.LOOPBACK_IP)));
        assertTrue(text.contains("No network found, only this computer can connect: http://127.0.0.1:8080"));
    }

    @Test
    void localAddressIsAnIpNeverLocalhost() throws Exception {
        for (String address : ClassChatServer.localAddresses()) {
            assertTrue(address.matches("\\d+\\.\\d+\\.\\d+\\.\\d+"), address);
        }
    }

    @Test
    void registerNeedsAName() throws Exception {
        assertEquals(400, post("/register", "").statusCode());
        assertEquals(400, post("/register?name=" + encode("   "), "").statusCode());
    }

    @Test
    void emptyMessageIsRefused() throws Exception {
        post("/register?name=Nino", "");
        assertEquals(400, post("/message", "").statusCode());
        assertEquals(1, chat.getHistory().size());
    }

    @Test
    void onlyPostIsAllowed() throws Exception {
        HttpRequest get = HttpRequest.newBuilder(URI.create("http://localhost:" + server.getPort() + "/register?name=Giorgi")).GET().build();
        HttpResponse<String> response = client.send(get, HttpResponse.BodyHandlers.ofString());
        assertEquals(405, response.statusCode());
        assertTrue(chat.getHistory().isEmpty());
    }

    @Test
    void registeringAgainFromTheSameIpRenamesTheUser() throws Exception {
        post("/register?name=Giorgi", "");
        post("/register?name=Gio", "");
        post("/message?text=hi", "");

        assertEquals("*** Giorgi is now Gio", chat.getHistory().get(1));
        assertEquals("Gio: hi", chat.getHistory().get(2));
    }

    // --- ClassChat without HTTP: users are told apart by IP ---

    @Test
    void usersAreIdentifiedByIp() {
        chat.register("10.0.0.5", "Giorgi");
        chat.register("10.0.0.6", "Nino");

        chat.post("10.0.0.6", "Hi Giorgi");
        chat.post("10.0.0.5", "Hi Nino");

        assertEquals(List.of(
                "*** Giorgi joined from 10.0.0.5",
                "*** Nino joined from 10.0.0.6",
                "Nino: Hi Giorgi",
                "Giorgi: Hi Nino"), chat.getHistory());
        assertThrows(IllegalStateException.class, () -> chat.post("10.0.0.7", "who am I?"));
    }

    @Test
    void messagesCannotFakeOtherLines() {
        chat.register("10.0.0.5", "Giorgi");
        chat.post("10.0.0.5", "hi\nNino: I didn't do my homework");

        assertEquals("Giorgi: hi Nino: I didn't do my homework", chat.getHistory().get(1));
    }

    @Test
    void longMessagesAreCut() {
        chat.register("10.0.0.5", "Giorgi");
        chat.post("10.0.0.5", "x".repeat(1000));

        assertEquals("Giorgi: " + "x".repeat(ClassChat.MAX_MESSAGE_LENGTH) + "…", chat.getHistory().get(1));
    }
}

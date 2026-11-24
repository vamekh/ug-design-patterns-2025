package ge.edu.ug.patterns.behavioral.mediator.classchat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ClassChatClientTest {

    private final ClassChat chat = new ClassChat(new PrintStream(new ByteArrayOutputStream(), true, StandardCharsets.UTF_8));
    private final ByteArrayOutputStream clientOutput = new ByteArrayOutputStream();
    private ClassChatServer server;
    private ClassChatClient client;

    @BeforeEach
    void start() throws Exception {
        server = new ClassChatServer(chat, 0);
        server.start();
        client = new ClassChatClient("http://localhost:" + server.getPort(),
                new PrintStream(clientOutput, true, StandardCharsets.UTF_8));
    }

    @AfterEach
    void stop() {
        server.stop();
    }

    private void type(String... lines) {
        client.run(new Scanner(String.join("\n", lines)));
    }

    @Test
    void firstLineIsTheNameTheRestAreMessages() {
        type("Giorgi", "Hello class!", "", "Is the homework due today?");

        List<String> history = chat.getHistory();
        assertEquals(3, history.size());
        assertTrue(history.get(0).startsWith("*** Giorgi joined from "));
        assertEquals("Giorgi: Hello class!", history.get(1));
        assertEquals("Giorgi: Is the homework due today?", history.get(2));
        String printed = clientOutput.toString(StandardCharsets.UTF_8);
        assertTrue(printed.contains("Server: Welcome, Giorgi!"));
        assertTrue(printed.endsWith("Bye!\n"));
    }

    @Test
    void quitStopsReading() {
        type("Nino", "first", ClassChatClient.QUIT, "never sent");

        assertEquals("Nino: first", chat.getHistory().get(1));
        assertEquals(2, chat.getHistory().size());
    }

    @Test
    void unreachableServerIsReportedAndNameIsAskedAgain() {
        ClassChatClient offline = new ClassChatClient("http://localhost:1",
                new PrintStream(clientOutput, true, StandardCharsets.UTF_8));
        offline.run(new Scanner("Giorgi\n"));

        String printed = clientOutput.toString(StandardCharsets.UTF_8);
        assertTrue(printed.contains("Cannot reach http://localhost:1"));
        assertTrue(printed.contains("Type your name again:"));
    }
}

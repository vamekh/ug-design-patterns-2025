package ge.edu.ug.testutil;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Test helper: runs an action and returns everything it printed to System.out.
 * Lets tests assert on examples that communicate through the console.
 */
public final class ConsoleCapture {

    private ConsoleCapture() {
    }

    public static String run(Runnable action) {
        PrintStream original = System.out;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer, true, StandardCharsets.UTF_8));
        try {
            action.run();
        } finally {
            System.setOut(original);
        }
        String output = buffer.toString(StandardCharsets.UTF_8);
        original.print(output);
        return output;
    }
}

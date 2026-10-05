package ge.edu.ug.architectural.mvc.gradebook;

import ge.edu.ug.testutil.ConsoleCapture;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

// PROBLEM: there is no model to inspect - every test has to type commands into a fake console
// and search the printed text. To check "the average is 88" we assert on a formatted string.
class GradebookAppTest {

    private String runWith(String input) {
        GradebookApp app = new GradebookApp(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
        return ConsoleCapture.run(app::run);
    }

    @Test
    void addListAverageQuit() {
        String out = runWith("add Nino 95\nadd Giorgi 81\nlist\naverage\nquit\n");

        assertTrue(out.contains("Added Nino: 95"));
        assertTrue(out.contains("Nino: 95"));
        assertTrue(out.contains("Giorgi: 81"));
        assertTrue(out.contains("Average: 88.00") || out.contains("Average: 88,00")); // even the locale leaks in
        assertTrue(out.contains("Bye"));
    }

    @Test
    void invalidGradeIsRejected() {
        String out = runWith("add Nino 120\nlist\nquit\n");

        assertTrue(out.contains("Grade must be between 0 and 100"));
        assertFalse(out.contains("Nino: 120"));
    }
}

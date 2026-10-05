package ge.edu.ug.architectural.mvc.gradebook;

import ge.edu.ug.architectural.mvc.gradebook.controller.GradebookController;
import ge.edu.ug.architectural.mvc.gradebook.model.Gradebook;
import ge.edu.ug.architectural.mvc.gradebook.model.Student;
import ge.edu.ug.architectural.mvc.gradebook.view.CsvView;
import ge.edu.ug.architectural.mvc.gradebook.view.GradebookView;
import ge.edu.ug.testutil.ConsoleCapture;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GradebookAppTest {

    // Fake View: records what the controller and the model asked it to show.
    static class RecordingView implements GradebookView {
        final List<String> calls = new ArrayList<>();

        @Override
        public void studentAdded(Student student) {
            calls.add("added " + student.getName());
        }

        @Override
        public void showStudents(List<Student> students) {
            calls.add("students " + students.size());
        }

        @Override
        public void showAverage(double average) {
            calls.add("average " + average);
        }

        @Override
        public void showMessage(String message) {
            calls.add("message " + message);
        }
    }

    private RecordingView drive(Gradebook model, String... lines) {
        RecordingView view = new RecordingView();
        model.addListener(view);
        GradebookController controller = new GradebookController(model, view);
        for (String line : lines) {
            controller.handle(line);
        }
        return view;
    }

    @Test
    void addListAverageQuit() {
        Gradebook model = new Gradebook();
        RecordingView view = drive(model, "add Nino 95", "add Giorgi 81", "list", "average", "quit");

        assertEquals(2, model.getStudents().size());
        assertEquals(88.0, model.getAverage(), 0.001);
        assertEquals(List.of("added Nino", "added Giorgi", "students 2", "average 88.0", "message Bye"), view.calls);
    }

    @Test
    void invalidGradeIsRejected() {
        Gradebook model = new Gradebook();
        RecordingView view = drive(model, "add Nino 120", "add Nino abc");

        assertTrue(model.getStudents().isEmpty());
        assertEquals(List.of("message Grade must be between 0 and 100", "message Grade must be a number"), view.calls);
    }

    @Test
    void quitStopsTheController() {
        Gradebook model = new Gradebook();
        GradebookController controller = new GradebookController(model, new RecordingView());
        assertTrue(controller.handle("list"));
        assertFalse(controller.handle("quit"));
    }

    @Test
    void csvViewRendersSameModel() {
        Gradebook model = new Gradebook();
        CsvView csv = new CsvView();
        GradebookController controller = new GradebookController(model, csv);
        controller.handle("add Nino 95");
        controller.handle("add Giorgi 81");
        controller.handle("list");
        controller.handle("average");

        assertEquals("name,grade\nNino,95\nGiorgi,81\naverage,88.00\n", csv.getOutput());
    }

    @Test
    void consoleAppStillWorksEndToEnd() {
        String input = "add Nino 95\nadd Giorgi 81\nlist\naverage\nquit\n";
        GradebookApp app = new GradebookApp(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
        String out = ConsoleCapture.run(app::run);

        assertTrue(out.contains("Added Nino: 95"));
        assertTrue(out.contains("Giorgi: 81"));
        assertTrue(out.contains("Average: 88.00"));
        assertTrue(out.contains("Bye"));
    }
}

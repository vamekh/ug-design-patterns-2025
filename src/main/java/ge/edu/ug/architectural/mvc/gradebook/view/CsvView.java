package ge.edu.ug.architectural.mvc.gradebook.view;

import ge.edu.ug.architectural.mvc.gradebook.model.Student;

import java.util.List;
import java.util.Locale;

// A second View over the same model and controller - no logic was copied to add it.
public class CsvView implements GradebookView {
    private final StringBuilder output = new StringBuilder();

    @Override
    public void studentAdded(Student student) {
        // CSV is a snapshot format: nothing to write per change.
    }

    @Override
    public void showStudents(List<Student> students) {
        output.append("name,grade\n");
        for (Student student : students) {
            output.append(student.getName()).append(',').append(student.getGrade()).append('\n');
        }
    }

    @Override
    public void showAverage(double average) {
        output.append(String.format(Locale.ROOT, "average,%.2f\n", average));
    }

    @Override
    public void showMessage(String message) {
        // messages are not part of the CSV export
    }

    public String getOutput() {
        return output.toString();
    }
}

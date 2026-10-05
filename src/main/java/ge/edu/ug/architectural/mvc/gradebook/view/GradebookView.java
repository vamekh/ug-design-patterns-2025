package ge.edu.ug.architectural.mvc.gradebook.view;

import ge.edu.ug.architectural.mvc.gradebook.model.GradebookListener;
import ge.edu.ug.architectural.mvc.gradebook.model.Student;

import java.util.List;

// View: how the gradebook is presented. Also listens to the model for changes.
public interface GradebookView extends GradebookListener {
    void showStudents(List<Student> students);

    void showAverage(double average);

    void showMessage(String message);
}

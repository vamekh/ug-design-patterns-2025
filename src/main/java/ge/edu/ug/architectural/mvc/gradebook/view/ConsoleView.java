package ge.edu.ug.architectural.mvc.gradebook.view;

import ge.edu.ug.architectural.mvc.gradebook.model.Student;

import java.util.List;
import java.util.Locale;

// Concrete View: the original console output, now in one place.
public class ConsoleView implements GradebookView {

    @Override
    public void studentAdded(Student student) {
        System.out.println("Added " + student.getName() + ": " + student.getGrade());
    }

    @Override
    public void showStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student.getName() + ": " + student.getGrade());
        }
    }

    @Override
    public void showAverage(double average) {
        System.out.printf(Locale.ROOT, "Average: %.2f%n", average);
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
}

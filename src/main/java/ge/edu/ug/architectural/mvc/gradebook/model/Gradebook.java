package ge.edu.ug.architectural.mvc.gradebook.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Model: data and business rules only. Knows nothing about consoles, CSV or commands;
// it notifies registered listeners (Observer) whenever it changes.
public class Gradebook {
    private final List<Student> students = new ArrayList<>();
    private final List<GradebookListener> listeners = new ArrayList<>();

    public void addListener(GradebookListener listener) {
        listeners.add(listener);
    }

    public void addGrade(String name, int grade) {
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100");
        }
        Student student = new Student(name, grade);
        students.add(student);
        for (GradebookListener listener : listeners) {
            listener.studentAdded(student);
        }
    }

    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }

    public double getAverage() {
        double sum = 0;
        for (Student student : students) {
            sum += student.getGrade();
        }
        return students.isEmpty() ? 0 : sum / students.size();
    }
}

package ge.edu.ug.architectural.mvc.gradebook.model;

// Observer: anything that wants to react when the model changes.
public interface GradebookListener {
    void studentAdded(Student student);
}

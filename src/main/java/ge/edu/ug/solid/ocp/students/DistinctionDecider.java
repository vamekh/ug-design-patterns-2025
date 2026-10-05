package ge.edu.ug.solid.ocp.students;

// One distinction rule. New rules are new implementations; existing ones are never edited.
public interface DistinctionDecider {
    boolean isDistinction(Student student);
}

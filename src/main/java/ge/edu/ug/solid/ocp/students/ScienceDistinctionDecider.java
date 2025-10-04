package ge.edu.ug.solid.ocp.students;

public class ScienceDistinctionDecider implements DistinctionDecider {
    public boolean isDistinction(Student student) {
        return student.score >= 80;
    }
}

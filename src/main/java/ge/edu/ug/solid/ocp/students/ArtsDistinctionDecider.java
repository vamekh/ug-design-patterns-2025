package ge.edu.ug.solid.ocp.students;

public class ArtsDistinctionDecider implements DistinctionDecider {
    public boolean isDistinction(Student student) {
        return student.score >= 70;
    }
}

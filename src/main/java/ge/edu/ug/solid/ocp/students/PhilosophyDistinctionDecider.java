package ge.edu.ug.solid.ocp.students;

// Added later: a new faculty gets its own rule without modifying any existing class (open for extension, closed for modification)
public class PhilosophyDistinctionDecider implements DistinctionDecider {
    public boolean isDistinction(Student student) {
        return student.score >= 75;
    }
}

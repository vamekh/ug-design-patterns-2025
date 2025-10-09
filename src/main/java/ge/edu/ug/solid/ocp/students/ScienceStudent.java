package ge.edu.ug.solid.ocp.students;

public class ScienceStudent extends Student {
    public ScienceStudent(String name, String regNumber, double score, String department) {
        super(name, regNumber, score);
        super.department = department;
    }
}

package ge.edu.ug.solid.ocp.students;

public class ArtsStudent extends Student {
    public ArtsStudent(String name, String regNumber, double score, String department) {
        super(name, regNumber, score);
        super.department = department;
    }
}

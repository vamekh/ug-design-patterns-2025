package ge.edu.ug.solid.ocp.students;

public class Student {
    String name;
    String regNumber;
    String department;
    double score;

    public Student(String name, String regNumber, double score) {
        this.name = name;
        this.regNumber = regNumber;
        this.score = score;
    }

    public String toString() {
        return String.format("Name: %s\nReg no: %s\nDept: %s\nMarks: %f", name, regNumber, department, score);
    }
}


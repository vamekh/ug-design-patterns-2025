package ge.edu.ug.solid.ocp.students;

import java.util.List;

public class DistinctionDecider {
    List<String> scienceDepartments = List.of("Comp.Sc.", "Physics");
    List<String> artDepartments = List.of("History", "English");

    public void evaluateDistinction(Student student) {
        if (scienceDepartments.contains(student.department) && student.score >= 80) {
            System.out.println("Distinction awarded to " + student.name);
        } else if (artDepartments.contains(student.department) && student.score >= 70) {
            System.out.println("Distinction awarded to " + student.name);
        } else {
            System.out.println("No distinction awarded to " + student.name);
        }
    }
}

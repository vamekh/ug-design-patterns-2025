package ge.edu.ug.solid.ocp.students;

public class ArtsDistinctionDecider implements DistinctionDecider{
    public void evaluateDistinction(Student student) {
        if (student.score >= 70) {
            System.out.println("Distinction awarded to " + student.name);
        } else {
            System.out.println("No distinction awarded to " + student.name);
        }
    }
}

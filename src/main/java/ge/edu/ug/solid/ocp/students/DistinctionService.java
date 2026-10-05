package ge.edu.ug.solid.ocp.students;

import java.util.HashMap;
import java.util.Map;

// Picks the rule by department. Open for extension: a new faculty is registered, this class is not edited.
public class DistinctionService {
    private final Map<String, DistinctionDecider> decidersByDepartment = new HashMap<>();

    public DistinctionService register(String department, DistinctionDecider decider) {
        decidersByDepartment.put(department, decider);
        return this;
    }

    public boolean evaluateDistinction(Student student) {
        DistinctionDecider decider = decidersByDepartment.get(student.department);
        boolean distinction = decider != null && decider.isDistinction(student);
        if (distinction) {
            System.out.println("Distinction awarded to " + student.name);
        } else {
            System.out.println("No distinction awarded to " + student.name);
        }
        return distinction;
    }
}

package ge.edu.ug.solid.ocp.students;

import org.junit.jupiter.api.Test;

import java.util.List;

class StudentsTest {
    
    @Test
    void testBadExample() {
        // This example violates Open-Closed Principle (OCP)
        // DistinctionDecider class needs to be modified each time we want to add new distinction rules
        // Instead, we should define an interface for distinction rules and implement different strategies

        Student tesla = new ScienceStudent("Nikola", "Tesla", 80.0, "Comp.Sc.");
        Student einstein = new ScienceStudent("Albert", "Einstein", 70.0, "Physics");
        Student darwin = new ArtsStudent("Charles", "Darwin", 60.0, "History");
        Student john = new ArtsStudent("John", "Doe", 50.0, "English");
        List<Student> artsStudents = List.of( darwin, john);
        List<Student> scienceStudents = List.of( tesla, einstein);

        ArtsDistinctionDecider decider = new ArtsDistinctionDecider();
        artsStudents.forEach(decider::evaluateDistinction);

        ScienceDistinctionDecider scienceDecider = new ScienceDistinctionDecider();
        scienceStudents.forEach(scienceDecider::evaluateDistinction);
    }
}

package ge.edu.ug.solid.ocp.students;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StudentsTest {
    
    @Test
    void testGoodExample() {
        // This test demonstrates Open-Closed Principle (OCP):
        // 1. Each distinction rule is its own DistinctionDecider implementation
        // 2. DistinctionService picks the rule by department from a registry
        // 3. A new faculty is added by registering a new decider, no existing class is edited

        Student tesla = new Student("Nikola", "Tesla", "Comp.Sc.", 80.0);
        Student einstein = new Student("Albert", "Einstein", "Physics", 70.0);
        Student darwin = new Student("Charles", "Darwin", "History", 60.0);
        Student john = new Student("John", "Doe", "English", 50.0);
        List<Student> students = List.of(tesla, einstein, darwin, john);

        DistinctionDecider science = new ScienceDistinctionDecider();
        DistinctionDecider arts = new ArtsDistinctionDecider();
        DistinctionService service = new DistinctionService()
                .register("Comp.Sc.", science)
                .register("Physics", science)
                .register("History", arts)
                .register("English", arts);

        students.forEach(System.out::println);
        List<Boolean> distinctions = students.stream().map(service::evaluateDistinction).toList();
        assertEquals(List.of(true, false, false, false), distinctions);

        // A new faculty: one new class plus a registration, no edits to existing deciders or the service
        Student socrates = new Student("Socrates", "Athens", "Philosophy", 76.0);
        assertFalse(service.evaluateDistinction(socrates)); // not registered yet
        service.register("Philosophy", new PhilosophyDistinctionDecider());
        assertTrue(service.evaluateDistinction(socrates));
    }

    @Test
    void eachDeciderHoldsOneThreshold() {
        Student seventy = new Student("Jane", "Austen", "English", 70.0);

        assertTrue(new ArtsDistinctionDecider().isDistinction(seventy));
        assertFalse(new ScienceDistinctionDecider().isDistinction(seventy));
        assertFalse(new PhilosophyDistinctionDecider().isDistinction(seventy));
    }
}

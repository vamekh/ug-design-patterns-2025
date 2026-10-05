package ge.edu.ug.patterns.behavioral.observer.evaluationnotifier;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// PROBLEM: grades are posted, but students know nothing until each of them
// calls checkForNewEvaluations(). The test has to log every student in by hand.
class OnlineUGTest {

    @Test
    void studentsDoNotKnowAboutGradesUntilTheyCheck() {
        OnlineUG onlineUG = new OnlineUG();
        Student student1 = new Student(1001, onlineUG);
        Student student2 = new Student(1002, onlineUG);

        onlineUG.addEvaluation(1001, 85);
        onlineUG.addEvaluation(1002, 90);
        onlineUG.addEvaluation(1002, 95);

        assertTrue(student1.getReceivedEvaluations().isEmpty());
        assertTrue(student2.getReceivedEvaluations().isEmpty());

        student1.checkForNewEvaluations();
        student2.checkForNewEvaluations();

        assertEquals(List.of(85), student1.getReceivedEvaluations());
        assertEquals(List.of(90, 95), student2.getReceivedEvaluations());
    }
}

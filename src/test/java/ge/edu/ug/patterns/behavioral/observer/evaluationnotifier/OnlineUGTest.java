package ge.edu.ug.patterns.behavioral.observer.evaluationnotifier;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OnlineUGTest {

    @Test
    void studentsAreNotifiedAboutTheirOwnGrades() {
        OnlineUG onlineUG = new OnlineUG();
        // UG codes above 127: comparing Integer with == would silently notify nobody
        Student student1 = new Student(1001);
        Student student2 = new Student(1002);
        onlineUG.subscribe(student1);
        onlineUG.subscribe(student2);

        onlineUG.addEvaluation(1001, 85);
        onlineUG.addEvaluation(1002, 90);
        onlineUG.addEvaluation(1002, 95);

        assertEquals(List.of(85), student1.getReceivedEvaluations());
        assertEquals(List.of(90, 95), student2.getReceivedEvaluations());
    }

    @Test
    void unsubscribedStudentIsNoLongerNotified() {
        OnlineUG onlineUG = new OnlineUG();
        Student student = new Student(1001);
        onlineUG.subscribe(student);

        onlineUG.unsubscribe(student);
        onlineUG.addEvaluation(1001, 85);

        assertTrue(student.getReceivedEvaluations().isEmpty());
    }
}

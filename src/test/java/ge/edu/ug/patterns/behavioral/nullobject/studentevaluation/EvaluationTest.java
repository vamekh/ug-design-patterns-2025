package ge.edu.ug.patterns.behavioral.nullobject.studentevaluation;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

// ReportPrinter works only because it checks for null everywhere.
// Any other caller that forgets the check crashes (see testForgottenNullCheck).
class EvaluationTest {

    private final List<StudentEvaluation> evaluations = List.of(
            new StudentEvaluation(123, new EvaluationWithComment(80, "Good Job!")),
            new StudentEvaluation(124, new EvaluationWithComment(50, "You need to study more!!")),
            new StudentEvaluation(125),
            new StudentEvaluation(126, new EvaluationWithComment(50, null))
    );

    private final ReportPrinter printer = new ReportPrinter();

    @Test
    void testLines() {
        assertEquals("123: 80 - Good Job!", printer.line(evaluations.get(0)));
        assertEquals("125: 0 - Not yet evaluated!", printer.line(evaluations.get(2)));
        assertEquals("126: 50 - null", printer.line(evaluations.get(3)));
    }

    @Test
    void testTotalPoints() {
        assertEquals(180, printer.totalPoints(evaluations));
    }

    @Test
    void testTranscript() {
        String transcript = printer.transcript(evaluations);

        assertTrue(transcript.contains("124: 50 - You need to study more!!"));
        assertTrue(transcript.contains("125: 0 - Not yet evaluated!"));
    }

    @Test
    void testForgottenNullCheck() {
        StudentEvaluation notEvaluated = evaluations.get(2);

        assertNull(notEvaluated.getEvaluation());
        assertThrows(NullPointerException.class, () -> notEvaluated.getEvaluation().getComment());
    }
}

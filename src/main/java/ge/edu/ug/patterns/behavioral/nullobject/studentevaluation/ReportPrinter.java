package ge.edu.ug.patterns.behavioral.nullobject.studentevaluation;

import java.util.List;

// StudentEvaluation.getEvaluation() returns null for students who were not evaluated yet,
// so every method here repeats the same "!= null" check and the same fallback values.
// Forgetting one check anywhere in the code base means a NullPointerException.
public class ReportPrinter {

    public String line(StudentEvaluation student) {
        Evaluation evaluation = student.getEvaluation();
        if (evaluation != null) {
            return student.getUgCode() + ": " + evaluation.getEvaluation() + " - " + evaluation.getComment();
        }
        return student.getUgCode() + ": 0 - Not yet evaluated!";
    }

    public int totalPoints(List<StudentEvaluation> students) {
        int total = 0;
        for (StudentEvaluation student : students) {
            if (student.getEvaluation() != null) {
                total += student.getEvaluation().getEvaluation();
            }
        }
        return total;
    }

    public String transcript(List<StudentEvaluation> students) {
        StringBuilder transcript = new StringBuilder();
        for (StudentEvaluation student : students) {
            transcript.append(line(student)).append(System.lineSeparator());
        }
        return transcript.toString();
    }
}

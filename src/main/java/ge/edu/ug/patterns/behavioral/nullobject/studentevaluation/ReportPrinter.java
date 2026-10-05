package ge.edu.ug.patterns.behavioral.nullobject.studentevaluation;

import java.util.List;

// Client: treats every Evaluation the same way, no null checks needed
public class ReportPrinter {

    public String line(StudentEvaluation student) {
        Evaluation evaluation = student.getEvaluation();
        return student.getUgCode() + ": " + evaluation.getEvaluation() + " - " + evaluation.getComment();
    }

    public int totalPoints(List<StudentEvaluation> students) {
        int total = 0;
        for (StudentEvaluation student : students) {
            total += student.getEvaluation().getEvaluation();
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

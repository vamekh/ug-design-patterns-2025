package ge.edu.ug.patterns.behavioral.nullobject.studentevaluation;

public class StudentEvaluation {
    private final Integer ugCode;
    private final Evaluation evaluation;

    public StudentEvaluation(Integer ugCode, Evaluation evaluation) {
        this.ugCode = ugCode;
        this.evaluation = evaluation;
    }

    public StudentEvaluation(Integer ugCode) {
        this.ugCode = ugCode;
        this.evaluation = null; // not evaluated yet
    }

    public Integer getUgCode() {
        return ugCode;
    }

    // may return null! every caller has to remember to check
    public Evaluation getEvaluation() {
        return evaluation;
    }
}

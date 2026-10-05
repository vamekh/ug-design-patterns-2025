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
        this.evaluation = EvaluationNullObject.getInstance(); // not evaluated yet
    }

    public Integer getUgCode() {
        return ugCode;
    }

    // never returns null
    public Evaluation getEvaluation() {
        return evaluation;
    }
}

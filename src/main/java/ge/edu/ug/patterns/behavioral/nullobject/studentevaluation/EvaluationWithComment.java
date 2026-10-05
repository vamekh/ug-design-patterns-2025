package ge.edu.ug.patterns.behavioral.nullobject.studentevaluation;

public class EvaluationWithComment implements Evaluation {
    private final Integer evaluation;
    private final String comment;

    public EvaluationWithComment(Integer evaluation, String comment) {
        this.evaluation = evaluation;
        this.comment = comment;
    }

    @Override
    public Integer getEvaluation() {
        return evaluation;
    }

    @Override
    public String getComment() {
        return comment;
    }
}

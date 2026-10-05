package ge.edu.ug.patterns.behavioral.nullobject.studentevaluation;

// Null Object: a do-nothing Evaluation with neutral values, shared as a single instance
public class EvaluationNullObject implements Evaluation {

    private static final EvaluationNullObject INSTANCE = new EvaluationNullObject();

    private EvaluationNullObject() {
    }

    public static EvaluationNullObject getInstance() {
        return INSTANCE;
    }

    @Override
    public Integer getEvaluation() {
        return 0;
    }

    @Override
    public String getComment() {
        return "Not yet evaluated!";
    }
}

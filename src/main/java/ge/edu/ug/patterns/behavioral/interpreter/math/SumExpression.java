package ge.edu.ug.patterns.behavioral.interpreter.math;

// Non-terminal Expression
public class SumExpression implements MathExpression {
    private final MathExpression left;
    private final MathExpression right;

    public SumExpression(MathExpression left, MathExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double interpret() {
        return left.interpret() + right.interpret();
    }
}

package ge.edu.ug.patterns.behavioral.interpreter.math;

// Non-terminal Expression
public class MultiplyExpression implements MathExpression {
    private final MathExpression left;
    private final MathExpression right;

    public MultiplyExpression(MathExpression left, MathExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double interpret() {
        return left.interpret() * right.interpret();
    }
}

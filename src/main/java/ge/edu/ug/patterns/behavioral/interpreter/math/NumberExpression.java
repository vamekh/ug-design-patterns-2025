package ge.edu.ug.patterns.behavioral.interpreter.math;

// Terminal Expression
public class NumberExpression implements MathExpression {
    private final double value;

    public NumberExpression(double value) {
        this.value = value;
    }

    @Override
    public double interpret() {
        return value;
    }
}

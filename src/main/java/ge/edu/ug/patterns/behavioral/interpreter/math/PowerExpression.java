package ge.edu.ug.patterns.behavioral.interpreter.math;

// Non-terminal Expression
public class PowerExpression implements MathExpression {
    private final MathExpression base;
    private final MathExpression exponent;

    public PowerExpression(MathExpression base, MathExpression exponent) {
        this.base = base;
        this.exponent = exponent;
    }

    @Override
    public double interpret() {
        return Math.pow(base.interpret(), exponent.interpret());
    }
}

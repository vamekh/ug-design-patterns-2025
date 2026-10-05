package ge.edu.ug.patterns.behavioral.visitor.expression;

public class NumberExpression implements Expression {
    private final double value;

    public NumberExpression(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public double evaluate() {
        return value;
    }

    @Override
    public String print() {
        return value == Math.floor(value) ? String.valueOf((long) value) : String.valueOf(value);
    }
}

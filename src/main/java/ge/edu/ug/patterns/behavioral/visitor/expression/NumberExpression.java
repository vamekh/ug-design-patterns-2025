package ge.edu.ug.patterns.behavioral.visitor.expression;

// Concrete Element (leaf)
public class NumberExpression implements Expression {
    private final double value;

    public NumberExpression(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public <R> R accept(ExpressionVisitor<R> visitor) {
        return visitor.visit(this);
    }
}

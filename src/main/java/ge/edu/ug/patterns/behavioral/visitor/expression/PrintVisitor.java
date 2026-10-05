package ge.edu.ug.patterns.behavioral.visitor.expression;

// Concrete Visitor: renders the tree as a fully parenthesized string
public class PrintVisitor implements ExpressionVisitor<String> {
    @Override
    public String visit(NumberExpression expression) {
        double value = expression.getValue();
        return value == Math.floor(value) ? String.valueOf((long) value) : String.valueOf(value);
    }

    @Override
    public String visit(AddExpression expression) {
        return binary(expression.getLeft(), "+", expression.getRight());
    }

    @Override
    public String visit(SubtractExpression expression) {
        return binary(expression.getLeft(), "-", expression.getRight());
    }

    @Override
    public String visit(MultiplyExpression expression) {
        return binary(expression.getLeft(), "*", expression.getRight());
    }

    private String binary(Expression left, String operator, Expression right) {
        return "(" + left.accept(this) + " " + operator + " " + right.accept(this) + ")";
    }
}

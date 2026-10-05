package ge.edu.ug.patterns.behavioral.visitor.expression;

// Concrete Visitor: computes the value of the tree
public class EvaluateVisitor implements ExpressionVisitor<Double> {
    @Override
    public Double visit(NumberExpression expression) {
        return expression.getValue();
    }

    @Override
    public Double visit(AddExpression expression) {
        return expression.getLeft().accept(this) + expression.getRight().accept(this);
    }

    @Override
    public Double visit(SubtractExpression expression) {
        return expression.getLeft().accept(this) - expression.getRight().accept(this);
    }

    @Override
    public Double visit(MultiplyExpression expression) {
        return expression.getLeft().accept(this) * expression.getRight().accept(this);
    }
}

package ge.edu.ug.patterns.behavioral.visitor.expression;

// Visitor: one operation over the tree, returning a result of type R
public interface ExpressionVisitor<R> {
    R visit(NumberExpression expression);

    R visit(AddExpression expression);

    R visit(SubtractExpression expression);

    R visit(MultiplyExpression expression);
}

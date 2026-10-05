package ge.edu.ug.patterns.behavioral.visitor.expression;

// Element: the tree only knows how to accept a visitor
public interface Expression {
    <R> R accept(ExpressionVisitor<R> visitor);
}

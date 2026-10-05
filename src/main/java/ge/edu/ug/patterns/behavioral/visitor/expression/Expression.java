package ge.edu.ug.patterns.behavioral.visitor.expression;

// Every operation on the tree (evaluate, print, ...) is a method here,
// so adding a new one (e.g. derive or simplify) edits all four expression classes.
public interface Expression {
    double evaluate();

    String print();
}

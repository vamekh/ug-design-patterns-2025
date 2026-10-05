package ge.edu.ug.patterns.behavioral.visitor.ecommerce;

// Visitor: one visit method per concrete product
public interface Visitor {
    void visit(Books books);

    void visit(Clothing clothing);

    void visit(Electronics electronics);

    void visit(Furniture furniture);
}

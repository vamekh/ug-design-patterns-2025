package ge.edu.ug.patterns.behavioral.visitor.ecommerce;

// Element: products only know their data and how to accept a visitor
public interface Product {
    double getPrice();

    void accept(Visitor visitor);
}

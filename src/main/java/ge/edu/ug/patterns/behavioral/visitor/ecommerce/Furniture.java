package ge.edu.ug.patterns.behavioral.visitor.ecommerce;

// Concrete Element
public class Furniture implements Product {
    private final double price;

    public Furniture(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

package ge.edu.ug.patterns.behavioral.visitor.ecommerce;

// Concrete Element
public class Clothing implements Product {
    private final double price;

    public Clothing(double price) {
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

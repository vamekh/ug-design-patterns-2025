package ge.edu.ug.patterns.behavioral.visitor.ecommerce;

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
    public double calculateTaxes() {
        return 0;
    }

    @Override
    public double getMaxDiscount() {
        return 0;
    }

    @Override
    public double calculateShipping() {
        return 50.0;
    }
}

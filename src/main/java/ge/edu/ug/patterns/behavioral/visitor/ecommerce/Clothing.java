package ge.edu.ug.patterns.behavioral.visitor.ecommerce;

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
    public double calculateTaxes() {
        return price * 15 / 100;
    }

    @Override
    public double getMaxDiscount() {
        return price * 10 / 100;
    }

    @Override
    public double calculateShipping() {
        return 3.0;
    }
}

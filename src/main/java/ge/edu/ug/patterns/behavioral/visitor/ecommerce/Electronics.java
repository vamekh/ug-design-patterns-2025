package ge.edu.ug.patterns.behavioral.visitor.ecommerce;

public class Electronics implements Product {
    private final double price;

    public Electronics(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public double calculateTaxes() {
        return price * 20 / 100;
    }

    @Override
    public double getMaxDiscount() {
        return price * 15 / 100;
    }

    @Override
    public double calculateShipping() {
        return 10.0;
    }
}

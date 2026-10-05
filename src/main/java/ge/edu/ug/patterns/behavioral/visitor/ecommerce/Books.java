package ge.edu.ug.patterns.behavioral.visitor.ecommerce;

public class Books implements Product {
    private final double price;

    public Books(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public double calculateTaxes() {
        return price * 10 / 100;
    }

    @Override
    public double getMaxDiscount() {
        return price * 13 / 100;
    }

    @Override
    public double calculateShipping() {
        return 2.0;
    }
}

package ge.edu.ug.patterns.behavioral.visitor.ecommerce;

import java.util.ArrayList;
import java.util.List;

public class OnlineShop {
    private final List<Product> cart = new ArrayList<>();

    public void addToCart(Product product) {
        cart.add(product);
    }

    public double totalPrice() {
        double total = 0;
        for (Product product : cart) {
            total += product.getPrice();
        }
        return total;
    }

    public double totalTaxes() {
        double total = 0;
        for (Product product : cart) {
            total += product.calculateTaxes();
        }
        return total;
    }

    public double totalDiscount() {
        double total = 0;
        for (Product product : cart) {
            total += product.getMaxDiscount();
        }
        return total;
    }

    public double totalShipping() {
        double total = 0;
        for (Product product : cart) {
            total += product.calculateShipping();
        }
        return total;
    }
}

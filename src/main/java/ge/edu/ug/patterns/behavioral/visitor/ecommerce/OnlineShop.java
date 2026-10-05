package ge.edu.ug.patterns.behavioral.visitor.ecommerce;

import java.util.ArrayList;
import java.util.List;

// Client: runs a visitor over the whole cart
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
        TaxVisitor visitor = new TaxVisitor();
        visitAll(visitor);
        return visitor.getTotal();
    }

    public double totalDiscount() {
        DiscountVisitor visitor = new DiscountVisitor();
        visitAll(visitor);
        return visitor.getTotal();
    }

    public double totalShipping() {
        ShippingVisitor visitor = new ShippingVisitor();
        visitAll(visitor);
        return visitor.getTotal();
    }

    public void visitAll(Visitor visitor) {
        for (Product product : cart) {
            product.accept(visitor);
        }
    }
}

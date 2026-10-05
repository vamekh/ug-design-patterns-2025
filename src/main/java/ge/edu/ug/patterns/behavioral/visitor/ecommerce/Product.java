package ge.edu.ug.patterns.behavioral.visitor.ecommerce;

// Every new operation on products (taxes, discounts, shipping, ...) is added here
// and then has to be implemented again in Books, Clothing, Electronics and Furniture.
public interface Product {
    double getPrice();

    double calculateTaxes();

    double getMaxDiscount();

    double calculateShipping();
}

package ge.edu.ug.patterns.behavioral.strategy.shoppingcart;

// Strategy: one payment algorithm; returns a receipt line describing the payment.
public interface PaymentStrategy {
    String pay(int amount);
}

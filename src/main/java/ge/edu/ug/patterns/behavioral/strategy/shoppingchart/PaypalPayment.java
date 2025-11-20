package ge.edu.ug.patterns.behavioral.strategy.shoppingchart;

public class PaypalPayment implements PaymentStrategy {
    String email;

    public PaypalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Paypal from address: " + email);
    }
}

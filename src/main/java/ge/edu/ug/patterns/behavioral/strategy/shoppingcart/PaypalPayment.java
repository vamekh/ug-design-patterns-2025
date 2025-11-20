package ge.edu.ug.patterns.behavioral.strategy.shoppingcart;

public class PaypalPayment implements PaymentStrategy {
    String email;

    public PaypalPayment(String email) {
        this.email = email;
    }

    @Override
    public String pay(int amount) {
        String receipt = "Paid " + amount + " using Paypal with email: " + email;
        System.out.println(receipt);
        return receipt;
    }
}

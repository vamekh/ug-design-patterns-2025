package ge.edu.ug.concreteStrategies;

import strategy.PaymentStrategy;

public class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(int totalAmount) {
        System.out.println("Paying via PayPal " + totalAmount + "$");
    }
}

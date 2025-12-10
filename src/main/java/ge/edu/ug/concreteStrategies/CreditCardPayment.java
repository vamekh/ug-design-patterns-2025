package ge.edu.ug.concreteStrategies;

import strategy.PaymentStrategy;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(int totalAmount) {
        System.out.println("Paying with credit card " + totalAmount + "$");
    }
}

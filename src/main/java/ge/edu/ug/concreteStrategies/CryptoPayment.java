package ge.edu.ug.concreteStrategies;

import strategy.PaymentStrategy;

public class CryptoPayment implements PaymentStrategy {
    @Override
    public void pay(int totalAmount) {
        System.out.println("Paying with crypto " + totalAmount + "$");
    }
}

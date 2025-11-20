package ge.edu.ug.patterns.behavioral.strategy.shoppingcart;

public class BitcoinPayment implements PaymentStrategy {
    String bitcoinAddress;

    public BitcoinPayment(String bitcoinAddress) {
        this.bitcoinAddress = bitcoinAddress;
    }

    @Override
    public String pay(int amount) {
        String receipt = "Paid " + amount + " using Bitcoin from address: " + bitcoinAddress;
        System.out.println(receipt);
        return receipt;
    }
}

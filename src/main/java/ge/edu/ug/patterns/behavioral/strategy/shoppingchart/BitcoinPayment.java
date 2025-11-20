package ge.edu.ug.patterns.behavioral.strategy.shoppingchart;

public class BitcoinPayment{
    String bitcoinAddress;

    public BitcoinPayment(String bitcoinAddress) {
        this.bitcoinAddress = bitcoinAddress;
    }

    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Bitcoin from address: " + bitcoinAddress);
    }
}

package ge.edu.ug.patterns.behavioral.strategy.shoppingchart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingChart {
    private final String bitcoinAddress;
    private final String paypalEmail;

    private int totalAmount = 0;
    private List<Object> items = new ArrayList<>();

    public ShoppingChart(String bitcoinAddress, String paypalEmail) {
        this.bitcoinAddress = bitcoinAddress;
        this.paypalEmail = paypalEmail;
    }

    public void addItem(Object item, int price){
        items.add(item);
        totalAmount += price;
    }

    public void checkoutWithPaypal(){
        PaypalPayment paypalPayment = new PaypalPayment(this.paypalEmail);
        paypalPayment.pay(totalAmount);
    }

    public void checkoutWithBitCoin(){
        BitcoinPayment bitcoinPayment = new BitcoinPayment(this.bitcoinAddress);
        bitcoinPayment.pay(totalAmount);
    }
}

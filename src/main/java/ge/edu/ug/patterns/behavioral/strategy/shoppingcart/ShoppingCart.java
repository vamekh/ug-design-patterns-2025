package ge.edu.ug.patterns.behavioral.strategy.shoppingcart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private int totalAmount = 0;
    private List<String> items = new ArrayList<>();

    public void addItem(String item, int price) {
        items.add(item);
        totalAmount += price;
    }

    public List<String> getItems() {
        return List.copyOf(items);
    }

    // Context: delegates the payment to whichever strategy the client passes in.
    public String checkout(PaymentStrategy paymentStrategy) {
        return paymentStrategy.pay(totalAmount);
    }
}

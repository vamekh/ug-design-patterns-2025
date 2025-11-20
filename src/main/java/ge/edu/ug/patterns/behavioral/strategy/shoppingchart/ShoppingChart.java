package ge.edu.ug.patterns.behavioral.strategy.shoppingchart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingChart {
    private int totalAmount = 0;
    private List<Object> items = new ArrayList<>();

    public void addItem(Object item, int price) {
        items.add(item);
        totalAmount += price;
    }

    public void checkout(PaymentStrategy paymentStrategy) {
        paymentStrategy.pay(totalAmount);
    }


}

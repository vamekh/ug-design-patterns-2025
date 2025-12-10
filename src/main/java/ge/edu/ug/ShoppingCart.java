package ge.edu.ug;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private PaymentStrategy paymentStrategy;
    private List<ShopItem> itemsAdded = new ArrayList<>();

    public ShoppingCart() {

    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    void checkout(int totalAmount) {
        paymentStrategy.pay(totalAmount);
    }

    void addItem(ShopItem item) {
        itemsAdded.add(item);
    }

    int calculateTotalAmount() {
        int total = 0;

        for (ShopItem item: itemsAdded) {
            total += item.getPrice();
        }

        return total;
    }
}

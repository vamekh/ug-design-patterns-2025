package ge.edu.ug.antipatterns.godobject;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final String id;
    private final String customerEmail;
    private final List<OrderItem> items = new ArrayList<>();
    private String couponCode;

    public Order(String id, String customerEmail) {
        this.id = id;
        this.customerEmail = customerEmail;
    }

    public Order addItem(String name, double price, int quantity) {
        items.add(new OrderItem(name, price, quantity));
        return this;
    }

    public Order withCoupon(String couponCode) {
        this.couponCode = couponCode;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public String getCouponCode() {
        return couponCode;
    }
}

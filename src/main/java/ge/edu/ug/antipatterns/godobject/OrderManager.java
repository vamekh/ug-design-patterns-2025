package ge.edu.ug.antipatterns.godobject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// GOD OBJECT: OrderManager validates, prices, stores, emails and logs - all in one class.
// Every change (new coupon, new tax rule, a real database, SMS instead of e-mail) means editing
// this file, and nothing can be tested or reused on its own: to check one discount rule
// you must build the whole manager and place a full order.
public class OrderManager {
    private static final double TAX_RATE = 0.18;
    private static final double BULK_THRESHOLD = 500.0;
    private static final double BULK_DISCOUNT = 0.05;

    private final Map<String, Order> orders = new HashMap<>();
    private final Map<String, Double> totals = new HashMap<>();
    private final List<String> sentEmails = new ArrayList<>();
    private final List<String> log = new ArrayList<>();

    public double placeOrder(Order order) {
        // 1. validation
        if (order.getId() == null || order.getId().isBlank()) {
            throw new IllegalArgumentException("Order id is required");
        }
        if (order.getCustomerEmail() == null || !order.getCustomerEmail().contains("@")) {
            throw new IllegalArgumentException("Invalid customer e-mail: " + order.getCustomerEmail());
        }
        if (order.getItems().isEmpty()) {
            throw new IllegalArgumentException("Order has no items");
        }
        for (OrderItem item : order.getItems()) {
            if (item.getQuantity() <= 0 || item.getPrice() < 0) {
                throw new IllegalArgumentException("Invalid item: " + item.getName());
            }
        }
        if (orders.containsKey(order.getId())) {
            throw new IllegalArgumentException("Duplicate order: " + order.getId());
        }

        // 2. pricing: subtotal, coupon, bulk discount, tax
        double subtotal = 0;
        for (OrderItem item : order.getItems()) {
            subtotal += item.getPrice() * item.getQuantity();
        }
        double discount = 0;
        if ("SAVE10".equals(order.getCouponCode())) {
            discount += 0.10;
        } else if ("SAVE20".equals(order.getCouponCode())) {
            discount += 0.20;
        }
        if (subtotal >= BULK_THRESHOLD) {
            discount += BULK_DISCOUNT;
        }
        double afterDiscount = subtotal * (1 - discount);
        double total = Math.round(afterDiscount * (1 + TAX_RATE) * 100) / 100.0;

        // 3. persistence
        orders.put(order.getId(), order);
        totals.put(order.getId(), total);

        // 4. notification
        String email = "To: " + order.getCustomerEmail()
                + " | Your order " + order.getId() + " is confirmed. Total: " + total + " GEL";
        sentEmails.add(email);

        // 5. logging
        log.add("Order " + order.getId() + " placed, total " + total);
        return total;
    }

    public void cancelOrder(String id) {
        // validation again
        if (!orders.containsKey(id)) {
            throw new IllegalArgumentException("Unknown order: " + id);
        }
        // persistence again
        Order order = orders.remove(id);
        Double total = totals.remove(id);
        // notification again
        sentEmails.add("To: " + order.getCustomerEmail()
                + " | Your order " + id + " was cancelled. Refund: " + total + " GEL");
        // logging again
        log.add("Order " + id + " cancelled");
    }

    public Order findOrder(String id) {
        return orders.get(id);
    }

    public Double findTotal(String id) {
        return totals.get(id);
    }

    public List<String> getSentEmails() {
        return sentEmails;
    }

    public List<String> getLog() {
        return log;
    }
}

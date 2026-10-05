package ge.edu.ug.antipatterns.godobject;

import java.util.HashMap;
import java.util.Map;

// One responsibility: store and find orders (in memory; could become a real database).
public class OrderRepository {
    private final Map<String, Order> orders = new HashMap<>();
    private final Map<String, Double> totals = new HashMap<>();

    public void save(Order order, double total) {
        if (orders.containsKey(order.getId())) {
            throw new IllegalArgumentException("Duplicate order: " + order.getId());
        }
        orders.put(order.getId(), order);
        totals.put(order.getId(), total);
    }

    public Order remove(String id) {
        if (!orders.containsKey(id)) {
            throw new IllegalArgumentException("Unknown order: " + id);
        }
        totals.remove(id);
        return orders.remove(id);
    }

    public Order findOrder(String id) {
        return orders.get(id);
    }

    public Double findTotal(String id) {
        return totals.get(id);
    }
}

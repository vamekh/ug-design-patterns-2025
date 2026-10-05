package ge.edu.ug.antipatterns.godobject;

import java.util.ArrayList;
import java.util.List;

// Thin orchestrator: knows the ORDER of the steps and delegates each step.
public class OrderService {
    private final OrderValidator validator;
    private final PricingService pricing;
    private final OrderRepository repository;
    private final Notifier notifier;
    private final List<String> log = new ArrayList<>();

    public OrderService(OrderValidator validator, PricingService pricing,
                        OrderRepository repository, Notifier notifier) {
        this.validator = validator;
        this.pricing = pricing;
        this.repository = repository;
        this.notifier = notifier;
    }

    public double placeOrder(Order order) {
        validator.validate(order);
        double total = pricing.total(order);
        repository.save(order, total);
        notifier.orderConfirmed(order, total);
        log.add("Order " + order.getId() + " placed, total " + total);
        return total;
    }

    public void cancelOrder(String id) {
        Double total = repository.findTotal(id);
        Order order = repository.remove(id);
        notifier.orderCancelled(order, total);
        log.add("Order " + id + " cancelled");
    }

    public List<String> getLog() {
        return log;
    }
}

package ge.edu.ug.antipatterns.godobject;

// One responsibility: decide whether an order is well-formed.
public class OrderValidator {

    public void validate(Order order) {
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
    }
}

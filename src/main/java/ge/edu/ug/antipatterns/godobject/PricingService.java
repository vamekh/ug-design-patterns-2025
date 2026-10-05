package ge.edu.ug.antipatterns.godobject;

// One responsibility: compute the price (subtotal, coupon, bulk discount, tax).
public class PricingService {
    private static final double TAX_RATE = 0.18;
    private static final double BULK_THRESHOLD = 500.0;
    private static final double BULK_DISCOUNT = 0.05;

    public double total(Order order) {
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
        return Math.round(afterDiscount * (1 + TAX_RATE) * 100) / 100.0;
    }
}

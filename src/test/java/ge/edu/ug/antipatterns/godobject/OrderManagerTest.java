package ge.edu.ug.antipatterns.godobject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// The only way to test anything is through OrderManager.placeOrder(): to check a single
// discount rule we must also validate, store, "send" an e-mail and write a log line.
// There is no way to test pricing or validation in isolation.
class OrderManagerTest {

    @Test
    void placesOrderWithCouponAndTax() {
        OrderManager manager = new OrderManager();
        Order order = new Order("A-1", "nino@example.com")
                .addItem("Book", 100.0, 2)
                .addItem("Pen", 50.0, 1)
                .withCoupon("SAVE10");

        double total = manager.placeOrder(order);

        // 250 - 10% = 225, + 18% tax = 265.5
        assertEquals(265.5, total, 0.001);
        assertSame(order, manager.findOrder("A-1"));
        assertEquals(1, manager.getSentEmails().size());
        assertTrue(manager.getSentEmails().get(0).contains("nino@example.com"));
        assertEquals("Order A-1 placed, total 265.5", manager.getLog().get(0));
    }

    @Test
    void bulkDiscountNeedsAFullOrderJustToCheckPricing() {
        OrderManager manager = new OrderManager();
        // we only care about the price, but must provide a valid id, e-mail, etc.
        double total = manager.placeOrder(new Order("A-2", "giorgi@example.com").addItem("Laptop", 1000.0, 1));

        // 1000 - 5% bulk = 950, + 18% tax = 1121
        assertEquals(1121.0, total, 0.001);
    }

    @Test
    void rejectsInvalidOrders() {
        OrderManager manager = new OrderManager();
        assertThrows(IllegalArgumentException.class,
                () -> manager.placeOrder(new Order("A-3", "not-an-email").addItem("Book", 10.0, 1)));
        assertThrows(IllegalArgumentException.class,
                () -> manager.placeOrder(new Order("A-4", "ana@example.com")));
        assertTrue(manager.getSentEmails().isEmpty());
    }

    @Test
    void rejectsDuplicateOrder() {
        OrderManager manager = new OrderManager();
        manager.placeOrder(new Order("A-5", "ana@example.com").addItem("Book", 10.0, 1));
        assertThrows(IllegalArgumentException.class,
                () -> manager.placeOrder(new Order("A-5", "ana@example.com").addItem("Book", 10.0, 1)));
    }

    @Test
    void cancelsOrder() {
        OrderManager manager = new OrderManager();
        manager.placeOrder(new Order("A-6", "ana@example.com").addItem("Book", 10.0, 1));

        manager.cancelOrder("A-6");

        assertNull(manager.findOrder("A-6"));
        assertEquals(2, manager.getSentEmails().size());
        assertTrue(manager.getSentEmails().get(1).contains("cancelled"));
        assertThrows(IllegalArgumentException.class, () -> manager.cancelOrder("A-6"));
    }
}

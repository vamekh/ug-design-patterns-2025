package ge.edu.ug.antipatterns.godobject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Same scenarios as before, now through a thin OrderService.
// Each piece can also be tested on its own - see the last three tests.
class OrderServiceTest {
    private OrderRepository repository;
    private Notifier notifier;
    private OrderService service;

    @BeforeEach
    void setUp() {
        repository = new OrderRepository();
        notifier = new Notifier();
        service = new OrderService(new OrderValidator(), new PricingService(), repository, notifier);
    }

    @Test
    void placesOrderWithCouponAndTax() {
        Order order = new Order("A-1", "nino@example.com")
                .addItem("Book", 100.0, 2)
                .addItem("Pen", 50.0, 1)
                .withCoupon("SAVE10");

        double total = service.placeOrder(order);

        // 250 - 10% = 225, + 18% tax = 265.5
        assertEquals(265.5, total, 0.001);
        assertSame(order, repository.findOrder("A-1"));
        assertEquals(1, notifier.getSentEmails().size());
        assertTrue(notifier.getSentEmails().get(0).contains("nino@example.com"));
        assertEquals("Order A-1 placed, total 265.5", service.getLog().get(0));
    }

    @Test
    void rejectsInvalidOrders() {
        assertThrows(IllegalArgumentException.class,
                () -> service.placeOrder(new Order("A-3", "not-an-email").addItem("Book", 10.0, 1)));
        assertThrows(IllegalArgumentException.class,
                () -> service.placeOrder(new Order("A-4", "ana@example.com")));
        assertTrue(notifier.getSentEmails().isEmpty());
    }

    @Test
    void rejectsDuplicateOrder() {
        service.placeOrder(new Order("A-5", "ana@example.com").addItem("Book", 10.0, 1));
        assertThrows(IllegalArgumentException.class,
                () -> service.placeOrder(new Order("A-5", "ana@example.com").addItem("Book", 10.0, 1)));
    }

    @Test
    void cancelsOrder() {
        service.placeOrder(new Order("A-6", "ana@example.com").addItem("Book", 10.0, 1));

        service.cancelOrder("A-6");

        assertNull(repository.findOrder("A-6"));
        assertEquals(2, notifier.getSentEmails().size());
        assertTrue(notifier.getSentEmails().get(1).contains("cancelled"));
        assertThrows(IllegalArgumentException.class, () -> service.cancelOrder("A-6"));
    }

    // --- pieces in isolation: no service, no repository, no e-mails ---

    @Test
    void pricingAloneAppliesBulkDiscount() {
        // 1000 - 5% bulk = 950, + 18% tax = 1121
        double total = new PricingService().total(new Order("A-2", "giorgi@example.com").addItem("Laptop", 1000.0, 1));
        assertEquals(1121.0, total, 0.001);
    }

    @Test
    void validatorAloneRejectsBadItem() {
        Order order = new Order("A-7", "ana@example.com").addItem("Book", 10.0, 0);
        assertThrows(IllegalArgumentException.class, () -> new OrderValidator().validate(order));
    }

    @Test
    void notifierAloneFormatsConfirmation() {
        Notifier alone = new Notifier();
        alone.orderConfirmed(new Order("A-8", "ana@example.com"), 12.5);
        assertEquals("To: ana@example.com | Your order A-8 is confirmed. Total: 12.5 GEL",
                alone.getSentEmails().get(0));
    }
}

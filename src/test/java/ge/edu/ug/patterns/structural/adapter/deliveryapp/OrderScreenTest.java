package ge.edu.ug.patterns.structural.adapter.deliveryapp;

import ge.edu.ug.testutil.ConsoleCapture;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// The same OrderScreen works with our plain DeliveryApp or, through the adapter, with CoolLib.
class OrderScreenTest {

    private OrderScreen screen(IDeliveryApp display) {
        OrderScreen screen = new OrderScreen(display);
        screen.addMenu("Khinkali");
        screen.addMenu("Khachapuri");
        screen.addOrder("Table 1: Khinkali x10");
        screen.addOrder("Table 2: Khachapuri");
        return screen;
    }

    @Test
    void showsMenusAndOrdersThroughCoolLib() {
        OrderScreen screen = screen(new CoolLibAdapter(new CoolLib()));

        String out = ConsoleCapture.run(() -> {
            screen.showMenus();
            screen.showOrders();
        });

        assertTrue(out.contains("Fancy menus: [Khinkali, Khachapuri]"));
        assertTrue(out.contains("Fancy orders: [Table 1: Khinkali x10, Table 2: Khachapuri]"));
    }

    @Test
    void filtersOrders() {
        OrderScreen screen = screen(new CoolLibAdapter(new CoolLib()));

        String out = ConsoleCapture.run(() -> screen.showOrdersContaining("Khinkali"));

        assertTrue(out.contains("Fancy orders: [Table 1: Khinkali x10]"));
    }

    @Test
    void sameScreenWorksWithPlainDisplay() {
        OrderScreen screen = screen(new DeliveryApp());

        String out = ConsoleCapture.run(screen::showMenus);

        assertTrue(out.contains("[Khinkali, Khachapuri]"));
        assertFalse(out.contains("Fancy"));
    }
}

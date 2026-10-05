package ge.edu.ug.patterns.structural.adapter.deliveryapp;

import ge.edu.ug.testutil.ConsoleCapture;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

// OrderScreen can only ever print through CoolLib: there is no way to give it a different
// display (plain console, a test double) without editing every show...() method.
class OrderScreenTest {

    private OrderScreen screen() {
        OrderScreen screen = new OrderScreen();
        screen.addMenu("Khinkali");
        screen.addMenu("Khachapuri");
        screen.addOrder("Table 1: Khinkali x10");
        screen.addOrder("Table 2: Khachapuri");
        return screen;
    }

    @Test
    void showsMenusAndOrdersThroughCoolLib() {
        OrderScreen screen = screen();

        String out = ConsoleCapture.run(() -> {
            screen.showMenus();
            screen.showOrders();
        });

        assertTrue(out.contains("Fancy menus: [Khinkali, Khachapuri]"));
        assertTrue(out.contains("Fancy orders: [Table 1: Khinkali x10, Table 2: Khachapuri]"));
    }

    @Test
    void filtersOrders() {
        OrderScreen screen = screen();

        String out = ConsoleCapture.run(() -> screen.showOrdersContaining("Khinkali"));

        assertTrue(out.contains("Fancy orders: [Table 1: Khinkali x10]"));
    }
}

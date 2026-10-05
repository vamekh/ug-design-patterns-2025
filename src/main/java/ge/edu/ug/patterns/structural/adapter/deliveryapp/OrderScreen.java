package ge.edu.ug.patterns.structural.adapter.deliveryapp;

import java.util.ArrayList;
import java.util.List;

// Client: depends only on IDeliveryApp and keeps working with List<String>
public class OrderScreen {
    private final IDeliveryApp display;
    private final List<String> menus = new ArrayList<>();
    private final List<String> orders = new ArrayList<>();

    public OrderScreen(IDeliveryApp display) {
        this.display = display;
    }

    public void addMenu(String menu) {
        menus.add(menu);
    }

    public void addOrder(String order) {
        orders.add(order);
    }

    public void showMenus() {
        display.displayMenus(menus);
    }

    public void showOrders() {
        display.displayOrders(orders);
    }

    public void showOrdersContaining(String keyword) {
        List<String> found = new ArrayList<>();
        for (String order : orders) {
            if (order.contains(keyword)) {
                found.add(order);
            }
        }
        display.displayOrders(found);
    }
}

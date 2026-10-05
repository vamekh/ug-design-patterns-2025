package ge.edu.ug.patterns.structural.adapter.deliveryapp;

import java.util.List;

// Our own plain implementation of the target
public class DeliveryApp implements IDeliveryApp {
    @Override
    public void displayMenus(List<String> menus) {
        System.out.println(menus);
    }

    @Override
    public void displayOrders(List<String> orders) {
        System.out.println(orders);
    }
}

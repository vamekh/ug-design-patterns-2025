package ge.edu.ug.patterns.structural.adapter.deliveryapp;

import java.util.List;

// Target: the display interface our app wants to use
public interface IDeliveryApp {
    void displayMenus(List<String> menus);

    void displayOrders(List<String> orders);
}

package ge.edu.ug.patterns.structural.adapter.deliveryapp;

import java.util.List;

public interface IDeliveryApp {
    void DisplayMenus(List<String> menus);

    void DisplayOrders(List<String> orders);
}

package ge.edu.ug.patterns.structural.adapter.deliveryapp;

import java.util.List;

public class DeliveryApp implements IDeliveryApp {
    public void DisplayMenus(List<String> menus){
        System.out.println(menus);
    }

    public void DisplayOrders(List<String> orders){
        System.out.println(orders);
    }
}

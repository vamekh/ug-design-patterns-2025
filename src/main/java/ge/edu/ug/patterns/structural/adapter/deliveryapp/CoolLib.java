package ge.edu.ug.patterns.structural.adapter.deliveryapp;

import java.util.Arrays;

public class CoolLib {
    public void DisplayMenus(String[] menus){
        System.out.println("Fancy menus: " + Arrays.toString(menus));
    }

    public void DisplayOrders(String[] orders){
        System.out.println("Fancy orders: " + Arrays.toString(orders));
    }
}

package ge.edu.ug.patterns.structural.adapter.deliveryapp;

import java.util.Arrays;

// Adaptee: third-party library, we cannot change it (hence the arrays and the PascalCase names)
public class CoolLib {
    public void DisplayMenus(String[] menus) {
        System.out.println("Fancy menus: " + Arrays.toString(menus));
    }

    public void DisplayOrders(String[] orders) {
        System.out.println("Fancy orders: " + Arrays.toString(orders));
    }
}

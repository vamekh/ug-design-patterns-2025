package ge.edu.ug.patterns.structural.adapter.deliveryapp;

import java.util.List;

// Adapter: converts List calls into CoolLib's array calls, in one place
public class CoolLibAdapter implements IDeliveryApp {
    private final CoolLib coolLib;

    public CoolLibAdapter(CoolLib coolLib) {
        this.coolLib = coolLib;
    }

    @Override
    public void displayMenus(List<String> menus) {
        coolLib.DisplayMenus(menus.toArray(new String[0]));
    }

    @Override
    public void displayOrders(List<String> orders) {
        coolLib.DisplayOrders(orders.toArray(new String[0]));
    }
}

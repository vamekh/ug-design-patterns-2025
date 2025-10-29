package ge.edu.ug.patterns.structural.adapter.deliveryapp;

import java.util.List;

public class CoolLibAdapter implements IDeliveryApp{
    CoolLib coolLib ;

    public CoolLibAdapter(CoolLib coolLib) {
        this.coolLib = coolLib;
    }

    @Override
    public void DisplayMenus(List<String> menus) {
        String[] menusArray = menus.toArray(new String[0]);
        coolLib.DisplayMenus(menusArray);
    }

    @Override
    public void DisplayOrders(List<String> orders) {
        String[] ordersArray = orders.toArray(new String[0]);
        coolLib.DisplayOrders(ordersArray);
    }
}

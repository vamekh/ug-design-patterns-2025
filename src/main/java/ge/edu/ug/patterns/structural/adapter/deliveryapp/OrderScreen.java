package ge.edu.ug.patterns.structural.adapter.deliveryapp;

import java.util.ArrayList;
import java.util.List;

// Our app works with List<String>, but CoolLib wants String[]. Every call site converts
// with toArray(...) and calls CoolLib directly, so the whole screen is welded to one
// third-party API: switching to plain console output or another library means rewriting it.
public class OrderScreen {
    private final CoolLib coolLib = new CoolLib();
    private final List<String> menus = new ArrayList<>();
    private final List<String> orders = new ArrayList<>();

    public void addMenu(String menu) {
        menus.add(menu);
    }

    public void addOrder(String order) {
        orders.add(order);
    }

    public void showMenus() {
        coolLib.DisplayMenus(menus.toArray(new String[0]));
    }

    public void showOrders() {
        coolLib.DisplayOrders(orders.toArray(new String[0]));
    }

    public void showOrdersContaining(String keyword) {
        List<String> found = new ArrayList<>();
        for (String order : orders) {
            if (order.contains(keyword)) {
                found.add(order);
            }
        }
        coolLib.DisplayOrders(found.toArray(new String[0]));
    }
}

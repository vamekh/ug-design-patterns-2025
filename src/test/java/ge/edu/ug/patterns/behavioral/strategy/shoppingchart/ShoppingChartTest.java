package ge.edu.ug.patterns.behavioral.strategy.shoppingchart;

import org.junit.jupiter.api.Test;

class ShoppingChartTest {
    @Test
    void testCheckoutWithPaypal() {
        ShoppingChart chart = new ShoppingChart("ABCD_BITCOIN", "my@paypal.com");
        chart.addItem("Item1", 100);
        chart.addItem("Item2", 200);

        chart.checkoutWithPaypal();
    }

}

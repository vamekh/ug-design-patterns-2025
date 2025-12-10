package ge.edu.ug.patterns.behavioral.strategy.shoppingchart;

import org.junit.jupiter.api.Test;

class ShoppingChartTest {

    @Test
    void testShoppingChart() {
        String bitcoinAddress = "ABCD_BITCOIN";
        String paypalEmail = "my@paypal.com";

        ShoppingChart chart = new ShoppingChart();
        chart.addItem("Item1", 100);
        chart.addItem("Item2", 200);

        PaymentStrategy strategy;
//        strategy = new BitcoinPayment(bitcoinAddress);
        strategy = new PaypalPayment(paypalEmail);
        chart.checkout(strategy);
    }

}

package ge.edu.ug.patterns.behavioral.strategy.shoppingchart;

import org.junit.jupiter.api.Test;

class ShoppingChartTest {
    @Test
    void testCheckoutWithPaypal() {
        ShoppingChart chart = new ShoppingChart();
        chart.addItem(new FidgetSpinner(100));
        chart.addItem(new FidgetSpinner(200));

        PaymentStrategy strategy;
//        strategy = new PaypalPayment("my@paypal.com");
        strategy = new BitcoinPayment("aaaaa");

        chart.checkout(strategy);
    }

}

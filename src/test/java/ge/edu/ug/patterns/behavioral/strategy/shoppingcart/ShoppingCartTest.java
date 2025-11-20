package ge.edu.ug.patterns.behavioral.strategy.shoppingcart;

import org.junit.jupiter.api.Test;

class ShoppingCartTest {
    @Test
    void testCheckoutWithPaypal() {
        ShoppingCart cart = new ShoppingCart("ABCD_BITCOIN", "my@paypal.com");
        cart.addItem("Item1", 100);
        cart.addItem("Item2", 200);

        cart.checkoutWithPaypal();
    }

}

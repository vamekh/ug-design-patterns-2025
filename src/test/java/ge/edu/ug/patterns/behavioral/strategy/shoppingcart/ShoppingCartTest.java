package ge.edu.ug.patterns.behavioral.strategy.shoppingcart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShoppingCartTest {
    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
        cart.addItem("Item1", 100);
        cart.addItem("Item2", 200);
    }

    @Test
    void testCheckoutWithPaypal() {
        String receipt = cart.checkout(new PaypalPayment("my@paypal.com"));

        assertEquals("Paid 300 using Paypal with email: my@paypal.com", receipt);
        assertEquals(List.of("Item1", "Item2"), cart.getItems());
    }

    @Test
    void testCheckoutWithBitcoin() {
        String receipt = cart.checkout(new BitcoinPayment("ABCD_BITCOIN"));

        assertEquals("Paid 300 using Bitcoin from address: ABCD_BITCOIN", receipt);
    }

    @Test
    void testCheckoutWithLambdaStrategy() {
        // A new payment method needs no change to ShoppingCart.
        String receipt = cart.checkout(amount -> "Paid " + amount + " by card");

        assertEquals("Paid 300 by card", receipt);
    }
}

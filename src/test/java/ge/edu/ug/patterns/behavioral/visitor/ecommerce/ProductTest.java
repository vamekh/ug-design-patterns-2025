package ge.edu.ug.patterns.behavioral.visitor.ecommerce;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// The totals are correct, but each of them lives inside the product classes:
// adding calculateShipping() meant editing Product, Books, Clothing, Electronics and Furniture.
// The next operation (e.g. insurance) will mean editing all of them again.
class ProductTest {

    private OnlineShop createShop() {
        OnlineShop shop = new OnlineShop();
        shop.addToCart(new Books(20));
        shop.addToCart(new Clothing(40));
        shop.addToCart(new Electronics(500));
        shop.addToCart(new Furniture(300));
        return shop;
    }

    @Test
    void testTotalPrice() {
        assertEquals(860.0, createShop().totalPrice(), 0.001);
    }

    @Test
    void testTotalTaxes() {
        // 2 + 6 + 100 + 0
        assertEquals(108.0, createShop().totalTaxes(), 0.001);
    }

    @Test
    void testTotalDiscount() {
        // 2.6 + 4 + 75 + 0
        assertEquals(81.6, createShop().totalDiscount(), 0.001);
    }

    @Test
    void testTotalShipping() {
        // 2 + 3 + 10 + 50
        assertEquals(65.0, createShop().totalShipping(), 0.001);
    }
}

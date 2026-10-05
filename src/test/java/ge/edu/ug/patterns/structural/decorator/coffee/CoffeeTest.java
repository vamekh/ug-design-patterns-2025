package ge.edu.ug.patterns.structural.decorator.coffee;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Every order is a separate class. A latte with double milk does not exist yet:
// to sell it we would have to write CoffeeWithDoubleMilk (and CoffeeWithDoubleMilkAndSugar...).
class CoffeeTest {

    @Test
    void simpleCoffee() {
        ICoffee coffee = new Coffee();
        assertEquals(200, coffee.getCost());
        assertEquals("Simple coffee", coffee.getDescription());
    }

    @Test
    void coffeeWithMilk() {
        ICoffee latte = new CoffeeWithMilk();
        assertEquals(300, latte.getCost());
        assertEquals("Simple coffee with milk", latte.getDescription());
    }

    @Test
    void coffeeWithMilkAndSugar() {
        ICoffee coffee = new CoffeeWithMilkAndSugar();
        assertEquals(350, coffee.getCost());
        assertEquals("Simple coffee with milk with sugar", coffee.getDescription());
    }
}

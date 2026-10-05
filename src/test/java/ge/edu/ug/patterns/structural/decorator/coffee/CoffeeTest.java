package ge.edu.ug.patterns.structural.decorator.coffee;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Orders are composed at runtime by wrapping decorators; no class per combination.
class CoffeeTest {

    @Test
    void simpleCoffee() {
        ICoffee coffee = new Coffee();
        assertEquals(200, coffee.getCost());
        assertEquals("Simple coffee", coffee.getDescription());
    }

    @Test
    void coffeeWithMilk() {
        ICoffee latte = new MilkDecorator(new Coffee());
        assertEquals(300, latte.getCost());
        assertEquals("Simple coffee with milk", latte.getDescription());
    }

    @Test
    void coffeeWithMilkAndSugar() {
        ICoffee coffee = new SugarDecorator(new MilkDecorator(new Coffee()));
        assertEquals(350, coffee.getCost());
        assertEquals("Simple coffee with milk with sugar", coffee.getDescription());
    }

    @Test
    void doubleMilkNeedsNoNewClass() {
        ICoffee coffee = new MilkDecorator(new MilkDecorator(new Coffee()));
        assertEquals(400, coffee.getCost());
        assertEquals("Simple coffee with milk with milk", coffee.getDescription());
    }
}

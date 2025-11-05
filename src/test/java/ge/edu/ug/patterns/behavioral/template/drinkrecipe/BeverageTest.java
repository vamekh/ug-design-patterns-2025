package ge.edu.ug.patterns.behavioral.template.drinkrecipe;

import org.junit.jupiter.api.Test;

class BeverageTest {
    @Test
    public void testBeverage() {
        Beverage coffee = new Coffee();
        Beverage tea = new Tea();
        coffee.prepare();
        tea.prepare();
    }
}

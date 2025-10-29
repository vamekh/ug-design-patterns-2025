package ge.edu.ug.patterns.structural.decorator.coffee;

import org.junit.jupiter.api.Test;

class CoffeeTest {

    @Test
    public void testCoffeeDecorator(){
        Coffee coffee = new Coffee();
        System.out.println(coffee.getDescription() + " $" + coffee.getCost()/100);

        ICoffee late = new MilkDecorator(coffee);
        System.out.println(late.getDescription() + " $" + late.getCost()/100);
    }

}

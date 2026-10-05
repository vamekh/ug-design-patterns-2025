package ge.edu.ug.patterns.structural.decorator.coffee;

// Every combination of add-ons needs its own subclass (CoffeeWithMilk, CoffeeWithSugar,
// CoffeeWithMilkAndSugar...). Prices and descriptions are copy-pasted into each one,
// so changing the price of milk means editing several classes, and "double milk" or
// a new add-on like syrup doubles the number of classes again.
public class Coffee implements ICoffee {
    @Override
    public int getCost() {
        return 200;
    }

    @Override
    public String getDescription() {
        return "Simple coffee";
    }
}

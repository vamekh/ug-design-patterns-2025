package ge.edu.ug.patterns.structural.decorator.coffee;

// Concrete Decorator
public class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(ICoffee coffee) {
        super(coffee);
    }

    @Override
    public int getCost() {
        return super.getCost() + 50;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with sugar";
    }
}

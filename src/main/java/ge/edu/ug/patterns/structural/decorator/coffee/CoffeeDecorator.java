package ge.edu.ug.patterns.structural.decorator.coffee;

// Base Decorator: wraps any ICoffee and forwards calls to it
public abstract class CoffeeDecorator implements ICoffee {
    private final ICoffee coffee;

    public CoffeeDecorator(ICoffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public int getCost() {
        return coffee.getCost();
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();
    }
}

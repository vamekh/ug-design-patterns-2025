package ge.edu.ug.patterns.structural.decorator.coffee;

public class MilkDecorator extends CoffeeDecorator{
    public MilkDecorator(ICoffee coffee) {
        super(coffee);
    }

    @Override
    public int getCost() {
        return super.getCost() + 100;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with milk";
    }
}

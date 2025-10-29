package ge.edu.ug.patterns.structural.decorator.coffee;

public abstract class CoffeeDecorator implements ICoffee{
    private ICoffee coffee;

    public CoffeeDecorator(ICoffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public int getCost() {
        return coffee.getCost();
    }

    @Override
    public String getDescription(){
        return coffee.getDescription();
    }
}

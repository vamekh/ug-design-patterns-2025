package ge.edu.ug.patterns.structural.decorator.coffee;

public class CoffeeWithMilk extends Coffee {
    @Override
    public int getCost() {
        return 200 + 100;
    }

    @Override
    public String getDescription() {
        return "Simple coffee with milk";
    }
}

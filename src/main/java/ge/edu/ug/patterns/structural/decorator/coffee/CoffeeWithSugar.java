package ge.edu.ug.patterns.structural.decorator.coffee;

public class CoffeeWithSugar extends Coffee {
    @Override
    public int getCost() {
        return 200 + 50;
    }

    @Override
    public String getDescription() {
        return "Simple coffee with sugar";
    }
}

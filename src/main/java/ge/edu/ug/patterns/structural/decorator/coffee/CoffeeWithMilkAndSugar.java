package ge.edu.ug.patterns.structural.decorator.coffee;

public class CoffeeWithMilkAndSugar extends Coffee {
    @Override
    public int getCost() {
        return 200 + 100 + 50;
    }

    @Override
    public String getDescription() {
        return "Simple coffee with milk with sugar";
    }
}

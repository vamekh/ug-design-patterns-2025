package ge.edu.ug.patterns.structural.decorator.coffee;

// Concrete Component
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

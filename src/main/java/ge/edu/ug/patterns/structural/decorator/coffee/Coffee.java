package ge.edu.ug.patterns.structural.decorator.coffee;

public class Coffee implements ICoffee{
    public int getCost() {
        return 200;
    }

    public String getDescription() {
        return "Simple coffee";
    }
}

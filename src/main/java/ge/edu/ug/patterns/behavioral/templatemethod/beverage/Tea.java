package ge.edu.ug.patterns.behavioral.templatemethod.beverage;

// Concrete Class
public class Tea extends HotBeverage {

    @Override
    protected void addCondiments() {
        System.out.println("Adding lemon");
    }

    @Override
    protected void addMainIngredient() {
        System.out.println("Putting a tea bag into the cup...");
    }
}

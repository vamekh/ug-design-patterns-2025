package ge.edu.ug.patterns.behavioral.templatemethod.beverage;

// Concrete Class
public class Tea extends HotBeverage {

    @Override
    protected void brew() {
        step("Steeping the tea");
    }

    @Override
    protected void addCondiments() {
        step("Adding lemon");
    }
}

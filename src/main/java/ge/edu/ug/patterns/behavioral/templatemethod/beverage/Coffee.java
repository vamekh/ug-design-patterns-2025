package ge.edu.ug.patterns.behavioral.templatemethod.beverage;

// Concrete Class
public class Coffee extends HotBeverage {
    private final boolean withMilkAndSugar;

    public Coffee() {
        this(true);
    }

    public Coffee(boolean withMilkAndSugar) {
        this.withMilkAndSugar = withMilkAndSugar;
    }

    @Override
    protected void brew() {
        step("Dripping coffee through filter");
    }

    @Override
    protected void addCondiments() {
        step("Adding sugar and milk");
    }

    @Override
    protected boolean wantsCondiments() {
        return withMilkAndSugar;
    }
}

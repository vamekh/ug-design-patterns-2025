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
    protected void addCondiments() {
        System.out.println("Adding sugar and milk");
    }

    @Override
    protected boolean wantsCondiments() {
        return withMilkAndSugar;
    }

    @Override
    protected void addMainIngredient() {
        System.out.println("Putting a cheap coffee into the cup...");
    }
}

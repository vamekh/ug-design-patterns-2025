package ge.edu.ug.patterns.behavioral.templatemethod.beverage;

import java.util.ArrayList;
import java.util.List;

public class Coffee {
    private final List<String> steps = new ArrayList<>();
    private final boolean withMilkAndSugar;

    public Coffee() {
        this(true);
    }

    public Coffee(boolean withMilkAndSugar) {
        this.withMilkAndSugar = withMilkAndSugar;
    }

    // Copy-pasted from Tea and edited by hand - pourInCup() got lost on the way
    public List<String> prepare() {
        steps.clear();
        boilWater();
        brew();
        if (withMilkAndSugar) {
            addCondiments();
        }
        return List.copyOf(steps);
    }

    private void boilWater() {
        step("Boiling water");
    }

    private void brew() {
        step("Dripping coffee through filter");
    }

    private void pourInCup() {
        step("Pouring into cup");
    }

    private void addCondiments() {
        step("Adding sugar and milk");
    }

    private void step(String description) {
        System.out.println(description);
        steps.add(description);
    }
}

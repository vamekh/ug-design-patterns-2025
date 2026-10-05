package ge.edu.ug.patterns.behavioral.templatemethod.beverage;

import java.util.ArrayList;
import java.util.List;

// Abstract Class: owns the recipe skeleton
public abstract class HotBeverage {
    private final List<String> steps = new ArrayList<>();

    // Template method: final, so no subclass can reorder or skip a step
    public final List<String> prepare() {
        steps.clear();
        boilWater();
        brew();
        pourInCup();
        if (wantsCondiments()) {
            addCondiments();
        }
        return List.copyOf(steps);
    }

    // Shared steps: written once
    private void boilWater() {
        step("Boiling water");
    }

    private void pourInCup() {
        step("Pouring into cup");
    }

    // Primitive operations: each beverage fills them in
    protected abstract void brew();

    protected abstract void addCondiments();

    // Hook: subclasses may override, default is "yes"
    protected boolean wantsCondiments() {
        return true;
    }

    protected void step(String description) {
        System.out.println(description);
        steps.add(description);
    }
}

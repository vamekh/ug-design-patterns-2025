package ge.edu.ug.patterns.behavioral.templatemethod.beverage;

import java.util.ArrayList;
import java.util.List;

// PROBLEM: Tea and Coffee each keep their own copy of the recipe in prepare().
// The shared steps (boilWater, pourInCup) and the step log are duplicated, and the
// copies have already drifted apart: Coffee never pours into the cup.
// Nothing forces every beverage to follow the same sequence.
public class Tea {
    private final List<String> steps = new ArrayList<>();

    public List<String> prepare() {
        steps.clear();
        boilWater();
        brew();
        pourInCup();
        addCondiments();
        return List.copyOf(steps);
    }

    private void boilWater() {
        step("Boiling water");
    }

    private void brew() {
        step("Steeping the tea");
    }

    private void pourInCup() {
        step("Pouring into cup");
    }

    private void addCondiments() {
        step("Adding lemon");
    }

    private void step(String description) {
        System.out.println(description);
        steps.add(description);
    }
}

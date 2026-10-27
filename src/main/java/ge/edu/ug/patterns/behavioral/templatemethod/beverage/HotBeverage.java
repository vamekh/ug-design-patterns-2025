package ge.edu.ug.patterns.behavioral.templatemethod.beverage;

// Abstract Class: owns the recipe skeleton
public abstract class HotBeverage {
    // Template method: final, so no subclass can reorder or skip a step
    public final void prepare() {
        boilWater();
        pourInCup();
        if (wantsCondiments()) {
            addCondiments();
        }
        stir();
    }

    // Shared steps: written once
    private void boilWater() {
        System.out.println("Boiling water");
    }

    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    protected abstract void addMainIngredient();

    // Primitive operations: each beverage fills them in
    protected void stir(){
        System.out.println("Stirring the beverage...");
    }

    protected abstract void addCondiments();

    // Hook: subclasses may override, default is "yes"
    protected boolean wantsCondiments() {
        return true;
    }
}

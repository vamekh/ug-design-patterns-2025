package ge.edu.ug.patterns.behavioral.template.drinkrecipe;

public class Coffee extends Beverage {
    @Override
    public void pourWater() {
        System.out.println("Pouring water");
    }

    @Override
    public void boilWater() {
        System.out.println("Boiling water");
    }

    @Override
    public void addSugar() {
        System.out.println("Adding sugar to the coffee");
    }

    @Override
    public void stir() {
        System.out.println("Stirring the coffee");
    }

    @Override
    public void putMainIngredient() {
        System.out.println("Adding the coffee beans");
    }
}

package ge.edu.ug.patterns.behavioral.template.drinkrecipe;

public class Tea extends Beverage {
    public Tea() {}

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
        System.out.printf("Adding sugar to tea");
    }

    @Override
    public void stir() {
        System.out.printf("Stirring the tea");
    }

    @Override
    public void putMainIngredient() {
        System.out.println("Putting the Ceylon tea leaves");
    }
}

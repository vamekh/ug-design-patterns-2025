package ge.edu.ug.patterns.behavioral.template.drinkrecipe;

public abstract class Beverage {
    public abstract void pourWater();
    public abstract void boilWater();
    public abstract void addSugar();
    public abstract void stir();
    public abstract void putMainIngredient();

    public void prepare(){
        pourWater();
        boilWater();
        addSugar();
        putMainIngredient();
        stir();
    }
}

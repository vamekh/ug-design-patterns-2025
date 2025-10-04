package ge.edu.ug.patterns.creational.simplefactory.animals;

public class Dog implements Animal{
    public Dog(){
        System.out.println("Dog created");
    }

    @Override
    public void displayBehavior() {
        System.out.println("Dog barks");
    }
}

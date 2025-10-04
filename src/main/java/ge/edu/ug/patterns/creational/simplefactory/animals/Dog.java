package ge.edu.ug.patterns.creational.simplefactory.animals;

public class Dog implements Animal{
    Dog(){
    }

    @Override
    public String behavior() {
        return "Dog barks";
    }
}

package ge.edu.ug.patterns.creational.simplefactory.animals;

public class Tiger implements Animal{
    protected Tiger(){
        System.out.println("Tiger created");
    }

    @Override
    public void displayBehavior() {
        System.out.println("Tiger roars");
    }
}

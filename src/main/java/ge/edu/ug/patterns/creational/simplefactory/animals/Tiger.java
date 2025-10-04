package ge.edu.ug.patterns.creational.simplefactory.animals;

public class Tiger implements Animal{
    Tiger(){
    }

    @Override
    public String behavior() {
        return "Tiger roars";
    }
}

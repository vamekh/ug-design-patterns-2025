package ge.edu.ug.patterns.creational.simplefactory.animals;

public class AnimalFactory {
    public Animal createAnimal(String type){
        if(type.equalsIgnoreCase("dog")){
            return new Dog();
        }else if(type.equalsIgnoreCase("tiger")){
            return new Tiger();
        }
        return null;
    }
}

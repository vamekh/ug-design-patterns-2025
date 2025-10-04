package ge.edu.ug.patterns.creational.simplefactory.animals;


public class AnimalFactory {
    public Animal createAnimal(String type) {
        if (type.equalsIgnoreCase("dog")) {
            return new Dog();
        } else if (type.equalsIgnoreCase("tiger")) {
            return new Tiger();
        } else {
            System.out.println("You can create either a 'dog' or a 'tiger'. ");
            throw new IllegalArgumentException("Unknown animal cannot be instantiated.");
        }
    }
}

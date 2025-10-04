package ge.edu.ug.patterns.creational.simplefactory.animals;


public class AnimalFactory {
    public Animal createAnimal(String type) {
        if ("dog".equalsIgnoreCase(type)) {
            return new Dog();
        } else if ("tiger".equalsIgnoreCase(type)) {
            return new Tiger();
        } else {
            throw new IllegalArgumentException(
                    "Unknown animal type: " + type + " (expected 'dog' or 'tiger')");
        }
    }
}

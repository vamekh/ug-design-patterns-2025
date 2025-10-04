package ge.edu.ug.patterns.creational.simplefactory.animals;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class AnimalsTest {
    @Test
    void testAnimals() {
        // Benefits of Simple Factory Pattern:
        // 1. Encapsulates object creation logic in a single place
        // 2. Reduces coupling between creation logic and object usage
        // 3. Makes adding new types easier without changing client code
        // 4. Provides a consistent way to create objects

        String animalNamesCsv = "Tiger, Dog";
        String[] animalNames = animalNamesCsv.split(", ");

        AnimalFactory animalFactory = new AnimalFactory();

        Arrays.stream(animalNames)
                .map(animalFactory::createAnimal)
                .forEach(Animal::displayBehavior);
    }
}

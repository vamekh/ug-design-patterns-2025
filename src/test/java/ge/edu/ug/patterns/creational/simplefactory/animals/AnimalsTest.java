package ge.edu.ug.patterns.creational.simplefactory.animals;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

        List<Animal> animals = Arrays.stream(animalNames)
                .map(animalFactory::createAnimal)
                .toList();

        assertInstanceOf(Tiger.class, animals.get(0));
        assertInstanceOf(Dog.class, animals.get(1));
        assertEquals(List.of("Tiger roars", "Dog barks"),
                animals.stream().map(Animal::behavior).toList());
    }

    @Test
    void unknownOrNullTypeIsRejected() {
        AnimalFactory animalFactory = new AnimalFactory();

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> animalFactory.createAnimal("cat"));
        assertEquals("Unknown animal type: cat (expected 'dog' or 'tiger')", e.getMessage());
        assertThrows(IllegalArgumentException.class, () -> animalFactory.createAnimal(null));
    }
}

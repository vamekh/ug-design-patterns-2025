package ge.edu.ug.patterns.creational.simplefactory.animals;

import org.junit.jupiter.api.Test;

class AnimalsTest {
    @Test
    void testAnimals() {
        // This code directly creates concrete objects (Tiger, Dog)
        // which creates tight coupling and makes it harder to change the object creation process
        // or add new animal types without modifying existing code

        Tiger tiger = new Tiger();
        tiger.displayBehavior();

        Dog dog = new Dog();
        dog.displayBehavior();
    }
}

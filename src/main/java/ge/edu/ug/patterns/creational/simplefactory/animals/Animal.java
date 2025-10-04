package ge.edu.ug.patterns.creational.simplefactory.animals;

public interface Animal {
    String behavior();

    default void displayBehavior() {
        System.out.println(behavior());
    }
}

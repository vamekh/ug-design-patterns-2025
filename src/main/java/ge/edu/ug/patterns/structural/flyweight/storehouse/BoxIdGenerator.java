package ge.edu.ug.patterns.structural.flyweight.storehouse;

public class BoxIdGenerator {
    private static int currentId = 10000;

    public static synchronized int getNextId() {
        return currentId++;
    }
}

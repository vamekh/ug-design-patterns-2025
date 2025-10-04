package ge.edu.ug.patterns.creational.factorymethod.logistics;

// Concrete Product
public class Ship implements Transport {
    @Override
    public void deliver(String destination, String cargo) {
        System.out.printf("Delivering %s to %s by ship...", cargo, destination);
    }
}

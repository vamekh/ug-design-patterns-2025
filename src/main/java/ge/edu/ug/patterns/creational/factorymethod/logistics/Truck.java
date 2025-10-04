package ge.edu.ug.patterns.creational.factorymethod.logistics;

// Concrete Product
public class Truck implements Transport{
    @Override
    public void deliver(String destination, String cargo) {
        System.out.printf("Delivering %s to %s by truck...", cargo, destination);
    }
}

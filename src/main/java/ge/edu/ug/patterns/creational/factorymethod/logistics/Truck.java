package ge.edu.ug.patterns.creational.factorymethod.logistics;

// Concrete Product
public class Truck extends Transport{
    @Override
    public String deliver(String destination, String cargo) {
        return String.format("Delivering %s to %s by truck...", cargo, destination);
    }
}

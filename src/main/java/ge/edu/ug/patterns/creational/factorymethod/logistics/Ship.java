package ge.edu.ug.patterns.creational.factorymethod.logistics;

// Concrete Product
public class Ship extends Transport{
    @Override
    public String deliver(String destination, String cargo) {
        return String.format("Delivering %s to %s by ship...", cargo, destination);
    }
}

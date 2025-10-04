package ge.edu.ug.patterns.creational.factorymethod.logistics;

public class Truck extends Transport{
    @Override
    public void deliver(String cargo) {
        System.out.printf("Delivering %s by truck...", cargo);
    }
}

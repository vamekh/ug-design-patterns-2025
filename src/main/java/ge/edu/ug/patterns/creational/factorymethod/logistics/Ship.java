package ge.edu.ug.patterns.creational.factorymethod.logistics;

public class Ship extends Transport{
    @Override
    public void deliver(String cargo) {
        System.out.printf("Delivering %s by ship...", cargo);
    }
}

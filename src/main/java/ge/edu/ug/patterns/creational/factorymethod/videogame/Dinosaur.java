package ge.edu.ug.patterns.creational.factorymethod.videogame;

public class Dinosaur implements Enemy{
    @Override
    public void spawn() {
        System.out.println("Dinosaur spawned!");
    }
}

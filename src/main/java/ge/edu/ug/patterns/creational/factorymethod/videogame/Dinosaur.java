package ge.edu.ug.patterns.creational.factorymethod.videogame;

// Concrete Product
public class Dinosaur implements Enemy{
    @Override
    public void spawn() {
        System.out.println("Dinosaur spawned!");
    }
}

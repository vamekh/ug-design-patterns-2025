package ge.edu.ug.patterns.creational.factorymethod.videogame;

// Concrete Product
public class Dragon implements Enemy {
    @Override
    public void spawn() {
        System.out.println("Dragon spawned!");
    }
}

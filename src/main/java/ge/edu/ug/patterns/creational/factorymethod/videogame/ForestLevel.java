package ge.edu.ug.patterns.creational.factorymethod.videogame;

// Concrete Creator
public class ForestLevel extends Level{
    @Override
    public Enemy createEnemy() {
        return new Dinosaur();
    }
}

package ge.edu.ug.patterns.creational.factorymethod.videogame;

// Concrete Creator
public class ForestLevel extends Level{
    @Override
    protected Enemy createEnemy() {
        return new Dinosaur();
    }
}

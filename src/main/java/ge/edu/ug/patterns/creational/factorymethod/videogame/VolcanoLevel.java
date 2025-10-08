package ge.edu.ug.patterns.creational.factorymethod.videogame;

// Concrete Creator
public class VolcanoLevel extends Level {
    @Override
    public Enemy createEnemy() {
        return new Dragon();
    }
}

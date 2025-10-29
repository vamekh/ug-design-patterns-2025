package ge.edu.ug.patterns.creational.factorymethod.videogame;

public class Level2 extends Level{
    public Level2() {
        this.levelType = "Volcano";
    }

    public Enemy createEnemy() {
        return  new Dragon();
    }

    public Obstacle createObstacle() {
        return new Lava();
    }
}

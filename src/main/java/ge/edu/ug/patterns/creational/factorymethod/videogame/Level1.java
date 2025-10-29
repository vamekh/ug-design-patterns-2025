package ge.edu.ug.patterns.creational.factorymethod.videogame;

public class Level1 extends Level{

    public Level1(){
        this.levelType = "Forest";
    }

    public Enemy createEnemy() {
        return  new Dinosaur();
    }

    @Override
    public Obstacle createObstacle() {
        return new River();
    }
}

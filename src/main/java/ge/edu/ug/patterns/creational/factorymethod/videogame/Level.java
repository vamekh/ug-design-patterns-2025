package ge.edu.ug.patterns.creational.factorymethod.videogame;

public abstract class Level implements ILevel {
    protected String levelType;

    // Tightly coupled creation logic
    public abstract Enemy createEnemy();
    public abstract Obstacle createObstacle();

    public void startLevel() {
        System.out.println("\n--- Starting " + levelType + " Level ---");
        Enemy enemy = createEnemy();
        enemy.spawn();
        Obstacle obstacle = createObstacle();
        System.out.println("OMG there is an " + obstacle.getName() + " on the way");
        obstacle.getName();
    }
}

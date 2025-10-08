package ge.edu.ug.patterns.creational.factorymethod.videogame;

// Abstract Creator
public abstract class Level {

    // The FACTORY METHOD: Subclasses implement this to create a specific product (Enemy)
    public abstract Enemy createEnemy();

    // Core logic that uses the product (Enemy) can remain here.
    // This method is now decoupled from the actual enemy implementation.
    public void startLevel() {
        System.out.println("\n--- Starting Level ---");
        Enemy enemy = createEnemy();
        enemy.spawn();
    }
}

package ge.edu.ug.patterns.creational.factorymethod.videogame;

// Abstract Creator
public abstract class Level {

    // The FACTORY METHOD: Subclasses implement this to create a specific product (Enemy)
    protected abstract Enemy createEnemy();

    // Core logic that uses the product (Enemy) can remain here.
    // This method is now decoupled from the actual enemy implementation.
    // Returns the enemy it spawned so callers (and tests) can see what the level created.
    public Enemy startLevel() {
        System.out.println("\n--- Starting " + getClass().getSimpleName() + " ---");
        Enemy enemy = createEnemy();
        enemy.spawn();
        return enemy;
    }
}

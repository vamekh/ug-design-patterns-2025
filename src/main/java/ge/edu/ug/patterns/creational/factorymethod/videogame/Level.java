package ge.edu.ug.patterns.creational.factorymethod.videogame;

public class Level {
    private String levelType;

    public Level(String levelType) {
        this.levelType = levelType;
    }

    // Tightly coupled creation logic
    public Enemy createEnemy() {
        return switch (levelType) {
            case "Forest" -> new Dinosaur();
            case "Volcano" -> new Dragon();
            // PROBLEM: Need to modify this method every time a new enemy type is added!
            default -> throw new IllegalArgumentException("Unknown level type: " + levelType);
        };
    }

    public void startLevel() {
        System.out.println("\n--- Starting " + levelType + " Level ---");
        Enemy enemy = createEnemy();
        enemy.spawn();
    }
}

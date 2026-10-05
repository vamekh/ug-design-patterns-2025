package ge.edu.ug.patterns.behavioral.memento.game;

// PROBLEM: to let HistoryManager take snapshots, Game exposes a getter AND a setter for every field.
// Anyone can now set health to 1000 or bullets to -5, and every new field must be copied by hand
// in HistoryManager (which already forgot bullets).
public class Game {
    private int health;
    private int shooterPosition;
    private int bullets = 10;

    public Game(int health, int shooterPosition) {
        this.health = health;
        this.shooterPosition = shooterPosition;
    }

    public void shoot() {
        bullets--;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public void changePosition(int newPosition) {
        shooterPosition = newPosition;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getShooterPosition() {
        return shooterPosition;
    }

    public void setShooterPosition(int shooterPosition) {
        this.shooterPosition = shooterPosition;
    }

    public int getBullets() {
        return bullets;
    }

    public void setBullets(int bullets) {
        this.bullets = bullets;
    }

    @Override
    public String toString() {
        return "Game{" +
                "health=" + health +
                ", shooterPosition=" + shooterPosition +
                ", bullets=" + bullets +
                "}";
    }
}

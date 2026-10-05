package ge.edu.ug.patterns.behavioral.memento.game;

// Originator: the only class that can create a Memento and read it back.
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

    public Memento save() {
        return new Memento(health, shooterPosition, bullets);
    }

    public void restore(Memento memento) {
        this.health = memento.health;
        this.shooterPosition = memento.shooterPosition;
        this.bullets = memento.bullets;
    }

    public int getHealth() {
        return health;
    }

    public int getShooterPosition() {
        return shooterPosition;
    }

    public int getBullets() {
        return bullets;
    }

    @Override
    public String toString() {
        return "Game{" +
                "health=" + health +
                ", shooterPosition=" + shooterPosition +
                ", bullets=" + bullets +
                "}";
    }

    // Memento: opaque to everyone else. Private fields and constructor are reachable only from Game.
    public static final class Memento {
        private final int health;
        private final int shooterPosition;
        private final int bullets;

        private Memento(int health, int shooterPosition, int bullets) {
            this.health = health;
            this.shooterPosition = shooterPosition;
            this.bullets = bullets;
        }
    }
}

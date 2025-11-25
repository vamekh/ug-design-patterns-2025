package ge.edu.ug.patterns.behavioral.memento.gameplay;

public class Game {
    private int health;
    private int shooterPosition;
    private int bullets = 10;

    public Game(int health, int shooterPosition) {
        this.health = health;
        this.shooterPosition = shooterPosition;
    }

    public void shoot(){
        bullets--;
    }

    public void takeDamage(int damage){
        health -= damage;
    }

    public void changePosition(int newPosition){
        shooterPosition = newPosition;
    }

    public GameMemento save(){
        return new GameMemento(health, shooterPosition, bullets);
    }

    public void restore(GameMemento memento){
        this.health = memento.health;
        this.shooterPosition = memento.shooterPosition;
        this.bullets = memento.bullets;
    }

    @Override
    public String toString() {
        return "Game{" +
                "health=" + health +
                ", shooterPosition=" + shooterPosition +
                ", bullets=" + bullets +
                "}";
    }

    protected class GameMemento {
        private final int health;
        private final int shooterPosition;
        private final int bullets;

        public GameMemento(int health, int shooterPosition, int bullets) {
            this.health = health;
            this.shooterPosition = shooterPosition;
            this.bullets = bullets;
        }
    }
}

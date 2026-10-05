package ge.edu.ug.patterns.behavioral.memento.game;

import java.util.ArrayDeque;
import java.util.Deque;

// The caretaker has to know Game's internals and copies them field by field.
public class HistoryManager {
    private final Deque<GameSnapshot> history = new ArrayDeque<>();

    public void save(Game game) {
        history.push(new GameSnapshot(game.getHealth(), game.getShooterPosition()));
        // bullets forgotten: nobody updated this line when the field was added
    }

    public boolean undo(Game game) {
        if (history.isEmpty()) return false;
        GameSnapshot snapshot = history.pop();
        game.setHealth(snapshot.health);
        game.setShooterPosition(snapshot.shooterPosition);
        return true;
    }

    private static class GameSnapshot {
        private final int health;
        private final int shooterPosition;

        GameSnapshot(int health, int shooterPosition) {
            this.health = health;
            this.shooterPosition = shooterPosition;
        }
    }
}

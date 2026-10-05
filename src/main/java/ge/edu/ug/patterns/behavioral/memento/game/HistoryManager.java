package ge.edu.ug.patterns.behavioral.memento.game;

import java.util.ArrayDeque;
import java.util.Deque;

// Caretaker: stores mementos without ever looking inside them.
public class HistoryManager {
    private final Deque<Game.Memento> history = new ArrayDeque<>();

    public void save(Game game) {
        history.push(game.save());
    }

    public boolean undo(Game game) {
        if (history.isEmpty()) return false;
        game.restore(history.pop());
        return true;
    }
}

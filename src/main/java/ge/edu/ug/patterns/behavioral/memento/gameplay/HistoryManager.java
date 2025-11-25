package ge.edu.ug.patterns.behavioral.memento.gameplay;

import java.util.ArrayList;
import java.util.List;

public class HistoryManager {
    private List<Game.GameMemento> mementos = new ArrayList<>();

    public void saveState(Game game) {
        mementos.add(game.save());
    }

    public Game.GameMemento restoreState(int index) {
        if(index < 0 || index >= mementos.size()){
            throw new IndexOutOfBoundsException("No memento found at index: " + index);
        }
        return mementos.get(index);
    }
}

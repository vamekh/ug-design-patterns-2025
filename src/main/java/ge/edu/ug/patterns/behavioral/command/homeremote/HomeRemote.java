package ge.edu.ug.patterns.behavioral.command.homeremote;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// Invoker: knows only the Command interface, not a single device class.
public class HomeRemote {
    private final Command[] slots;
    private final Deque<Command> history = new ArrayDeque<>();

    public HomeRemote(int slotCount) {
        slots = new Command[slotCount];
        Arrays.fill(slots, new NoCommand());
    }

    public void setCommand(int slot, Command command) {
        slots[slot] = command;
    }

    public void press(int slot) {
        slots[slot].execute();
        history.push(slots[slot]);
    }

    public void undoLast() {
        if (!history.isEmpty()) {
            history.pop().undo();
        }
    }
}

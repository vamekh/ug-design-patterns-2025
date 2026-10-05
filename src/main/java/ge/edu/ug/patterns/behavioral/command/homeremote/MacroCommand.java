package ge.edu.ug.patterns.behavioral.command.homeremote;

import java.util.List;

// Macro Command: several commands behind one button, undone in reverse order.
public class MacroCommand implements Command {
    private final List<Command> commands;

    public MacroCommand(List<Command> commands) {
        this.commands = List.copyOf(commands);
    }

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

    @Override
    public void undo() {
        for (int i = commands.size() - 1; i >= 0; i--) {
            commands.get(i).undo();
        }
    }
}

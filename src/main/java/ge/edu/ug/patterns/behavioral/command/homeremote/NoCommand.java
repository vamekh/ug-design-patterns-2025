package ge.edu.ug.patterns.behavioral.command.homeremote;

// Null Object: an empty slot does nothing instead of throwing NullPointerException.
public class NoCommand implements Command {
    @Override
    public void execute() {
    }

    @Override
    public void undo() {
    }
}

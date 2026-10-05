package ge.edu.ug.patterns.behavioral.command.homeremote;

// Concrete Command
public class DoorCloseCommand implements Command {
    private final DoorEngine doorEngine;

    public DoorCloseCommand(DoorEngine doorEngine) {
        this.doorEngine = doorEngine;
    }

    @Override
    public void execute() {
        doorEngine.close();
    }

    @Override
    public void undo() {
        doorEngine.open();
    }
}

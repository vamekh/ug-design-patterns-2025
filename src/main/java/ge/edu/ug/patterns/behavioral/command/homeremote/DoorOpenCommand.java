package ge.edu.ug.patterns.behavioral.command.homeremote;

// Concrete Command
public class DoorOpenCommand implements Command {
    private final DoorEngine doorEngine;

    public DoorOpenCommand(DoorEngine doorEngine) {
        this.doorEngine = doorEngine;
    }

    @Override
    public void execute() {
        doorEngine.open();
    }

    @Override
    public void undo() {
        doorEngine.close();
    }
}

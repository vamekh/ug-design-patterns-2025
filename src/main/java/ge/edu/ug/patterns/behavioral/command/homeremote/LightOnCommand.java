package ge.edu.ug.patterns.behavioral.command.homeremote;

// Concrete Command
public class LightOnCommand implements Command {
    private final SmartLightBulb smartLightBulb;

    public LightOnCommand(SmartLightBulb smartLightBulb) {
        this.smartLightBulb = smartLightBulb;
    }

    @Override
    public void execute() {
        smartLightBulb.switchOn();
    }

    @Override
    public void undo() {
        smartLightBulb.switchOff();
    }
}

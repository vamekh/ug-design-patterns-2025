package ge.edu.ug.patterns.behavioral.command.homeremote;

// Concrete Command
public class LightOffCommand implements Command {
    private final SmartLightBulb smartLightBulb;

    public LightOffCommand(SmartLightBulb smartLightBulb) {
        this.smartLightBulb = smartLightBulb;
    }

    @Override
    public void execute() {
        smartLightBulb.switchOff();
    }

    @Override
    public void undo() {
        smartLightBulb.switchOn();
    }
}

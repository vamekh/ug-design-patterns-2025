package ge.edu.ug.patterns.behavioral.command.homeremote;

// Receiver
public class SmartLightBulb {
    private boolean on;

    public void switchOn() {
        on = true;
        System.out.println("Smart light is on...");
    }

    public void switchOff() {
        on = false;
        System.out.println("Smart light is off...");
    }

    public boolean isOn() {
        return on;
    }
}

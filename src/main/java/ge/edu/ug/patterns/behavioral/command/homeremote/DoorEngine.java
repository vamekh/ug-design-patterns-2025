package ge.edu.ug.patterns.behavioral.command.homeremote;

// Receiver
public class DoorEngine {
    private boolean open;

    public void open() {
        open = true;
        System.out.println("Garage door is opening...");
    }

    public void close() {
        open = false;
        System.out.println("Garage door is closing...");
    }

    public boolean isOpen() {
        return open;
    }
}

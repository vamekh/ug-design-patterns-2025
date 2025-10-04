package ge.edu.ug.solid.dip.bulbswitch;

public class Switcher {
    private boolean on;
    private final Switchable device;

    public Switcher(Switchable device, boolean initialState) {
        this.device = device;
        this.on = initialState;
    }

    public void flip() {
        on = !on;
        this.device.flip(on);
    }

    public boolean isOn() {
        return on;
    }
}

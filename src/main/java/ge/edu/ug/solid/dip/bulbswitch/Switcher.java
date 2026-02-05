package ge.edu.ug.solid.dip.bulbswitch;

public class Switcher {
    boolean on;
    Switchable device;

    public Switcher(Switchable device, boolean initialState) {
        this.device = device;
        this.on = initialState;
    }

    public void flip() {
        on = !on;
        this.device.flip(on);
    }
}

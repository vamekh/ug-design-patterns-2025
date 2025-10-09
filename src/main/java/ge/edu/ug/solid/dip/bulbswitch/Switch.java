package ge.edu.ug.solid.dip.bulbswitch;

public class Switch {
    boolean on;
    OnOffDevice device;

    public Switch(OnOffDevice device, boolean initialState) {
        this.device = device;
        this.on = initialState;
    }

    public void flip() {
        on = !on;
        this.device.setOn(on);
    }
}

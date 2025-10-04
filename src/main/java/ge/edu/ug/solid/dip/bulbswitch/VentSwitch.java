package ge.edu.ug.solid.dip.bulbswitch;

public class VentSwitch {
    boolean on;
    Vent vent;

    public VentSwitch(Vent vent, boolean initialState) {
        this.vent = vent;
        this.on = initialState;
    }

    public void flip() {
        on = !on;
        this.vent.flip(on);
    }
}

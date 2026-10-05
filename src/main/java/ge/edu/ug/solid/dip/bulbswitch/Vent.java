package ge.edu.ug.solid.dip.bulbswitch;

public class Vent implements Switchable {
    private boolean on;

    public void flip(boolean on) {
        this.on = on;
        System.out.println("Vent is " + (on ? "on" : "off"));
    }

    public boolean isOn() {
        return on;
    }
}

package ge.edu.ug.solid.dip.bulbswitch;

public class LightBulb implements Switchable {
    private boolean on;

    @Override
    public void flip(boolean on) {
        this.on = on;
        System.out.println("Bulb is " + (on ? "on" : "off"));
    }

    @Override
    public boolean isOn() {
        return on;
    }
}

package ge.edu.ug.solid.dip.bulbswitch;

public class Vent implements Switchable {
    public void flip(boolean on) {
        System.out.println("Vent is " + (on ? "on" : "off"));
    }
}

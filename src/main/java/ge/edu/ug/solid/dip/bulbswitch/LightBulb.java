package ge.edu.ug.solid.dip.bulbswitch;

public class LightBulb implements OnOffDevice {
    @Override
    public void setOn(boolean on) {
        System.out.println("Bulb is " + (on ? "on" : "off"));
    }
}

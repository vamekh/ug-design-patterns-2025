package ge.edu.ug.solid.dip.bulbswitch;

public class Vent implements OnOffDevice{
    @Override
    public void setOn(boolean on) {
        System.out.println("Vent is " + (on ? "on" : "off"));
    }
}

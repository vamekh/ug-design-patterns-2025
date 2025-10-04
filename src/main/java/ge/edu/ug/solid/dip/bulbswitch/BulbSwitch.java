package ge.edu.ug.solid.dip.bulbswitch;

public class BulbSwitch {
    boolean on;
    LightBulb bulb;

    public BulbSwitch(LightBulb bulb, boolean initialState) {
        this.bulb = bulb;
        this.on = initialState;
    }

    public void flip() {
        on = !on;
        this.bulb.flip(on);
    }
}

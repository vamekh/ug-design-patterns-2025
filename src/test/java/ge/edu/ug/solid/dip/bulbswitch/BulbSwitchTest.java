package ge.edu.ug.solid.dip.bulbswitch;

import org.junit.jupiter.api.Test;

class BulbSwitchTest {
    // This test demonstrates violation of Dependency Inversion Principle (DIP)
    // BulbSwitch and VentSwitch depend directly on concrete LightBulb and Vent classes
    // Instead, both switches should depend on abstractions (e.g., ISwitchable interface)
    // which LightBulb and Vent should implement

    @Test
    public void testSwitch() {
        LightBulb bulb = new LightBulb();
        BulbSwitch bulbSwitcher = new BulbSwitch(bulb, true);
        bulbSwitcher.flip();

        Vent vent = new Vent();
        VentSwitch ventSwitcher = new VentSwitch(vent, true);
        ventSwitcher.flip();
    }

}

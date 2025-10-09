package ge.edu.ug.solid.dip.bulbswitch;

import org.junit.jupiter.api.Test;

class SwitchTest {
    // This test demonstrates violation of Dependency Inversion Principle (DIP)
    // BulbSwitch and VentSwitch depend directly on concrete LightBulb and Vent classes
    // Instead, both switches should depend on abstractions (e.g., ISwitchable interface)
    // which LightBulb and Vent should implement

    @Test
    public void testSwitch() {
        OnOffDevice bulb = new LightBulb();
        Switch switcher = new Switch(bulb, true);
        switcher.flip();

        OnOffDevice vent = new Vent();
        Switch ventSwitcher = new Switch(vent, true);
        ventSwitcher.flip();
        ventSwitcher.flip();
    }

}

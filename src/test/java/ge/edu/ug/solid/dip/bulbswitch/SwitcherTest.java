package ge.edu.ug.solid.dip.bulbswitch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SwitcherTest {
    // This test demonstrates compliance with Dependency Inversion Principle (DIP)
    // 1. High-level Switcher module depends on abstractions (likely a Switchable interface)
    // 2. Low-level modules (LightBulb, Vent) implement the abstraction
    // 3. Both high and low-level modules depend on abstractions, not concrete implementations

    @Test
    public void testSwitch() {
        Switchable bulb = new LightBulb();
        Switchable vent = new Vent();
        Switcher bulbSwitcher = new Switcher(bulb, false);
        Switcher ventSwitcher = new Switcher(vent, false);

        bulbSwitcher.flip();
        ventSwitcher.flip();
        assertTrue(bulb.isOn());
        assertTrue(vent.isOn());
        assertTrue(bulbSwitcher.isOn());

        bulbSwitcher.flip();
        assertFalse(bulb.isOn());
        assertFalse(bulbSwitcher.isOn());
        assertTrue(vent.isOn()); // switchers are independent
    }

    @Test
    public void switcherWorksWithAnySwitchable() {
        // A new device only implements Switchable; Switcher is unchanged
        Switchable fan = new Switchable() {
            private boolean on;

            public void flip(boolean on) {
                this.on = on;
            }

            public boolean isOn() {
                return on;
            }
        };
        Switcher fanSwitcher = new Switcher(fan, true);

        fanSwitcher.flip();
        assertFalse(fan.isOn());
    }

}

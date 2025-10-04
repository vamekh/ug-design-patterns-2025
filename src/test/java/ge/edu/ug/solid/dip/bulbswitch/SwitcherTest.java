package ge.edu.ug.solid.dip.bulbswitch;

import org.junit.jupiter.api.Test;

class SwitcherTest {
    // This test demonstrates compliance with Dependency Inversion Principle (DIP)
    // 1. High-level Switcher module depends on abstractions (likely a Switchable interface)
    // 2. Low-level modules (LightBulb, Vent) implement the abstraction
    // 3. Both high and low-level modules depend on abstractions, not concrete implementations

    @Test
    public void testSwitch() {
        Switcher bulbSwitcher = new Switcher(new LightBulb(), false);
        Switcher ventSwitcher = new Switcher(new Vent(), false);

        bulbSwitcher.flip();
        ventSwitcher.flip();
    }

}

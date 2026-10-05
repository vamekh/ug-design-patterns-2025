package ge.edu.ug.patterns.creational.builder.computer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

// PROBLEM: callers pass nulls to skip parts and must count positions ("is the 4th one display or gpu?").
// The "gaming" and "coding" presets are copy-pasted wherever such a PC is needed.
// Nothing stops a Computer without a processor: new Computer(null, null).
class ComputerTest {

    @Test
    public void testCustomComputer() {
        // only processor, ram and gpu wanted -> two nulls in the middle
        Computer computer = new Computer("Intel Core i7", "32GB", null, null, "RTX 4070");

        assertEquals("Intel Core i7", computer.getProcessor());
        assertNull(computer.getStorage());
        assertEquals("RTX 4070", computer.getGpu());
    }

    @Test
    public void testGamingPc() {
        // gaming preset, copy-paste #1
        Computer gamingPc = new Computer("Intel i5", "16GB", "1TB", "4K", "RTX 4070");

        assertEquals("Intel i5", gamingPc.getProcessor());
        assertEquals("4K", gamingPc.getDisplay());
    }

    @Test
    public void testGamingPcWithOtherDisplay() {
        // gaming preset, copy-paste #2 - changing the preset means editing every copy
        Computer gamingPc = new Computer("Intel i5", "16GB", "1TB", "2K", "RTX 4070");

        assertEquals("RTX 4070", gamingPc.getGpu());
        assertEquals("2K", gamingPc.getDisplay());
    }

    @Test
    public void testCodingPc() {
        // coding preset: no gpu, but we still have to pick the right constructor
        Computer codingPc = new Computer("Intel i9", "16GB", "1TB", "2K");

        assertEquals("Intel i9", codingPc.getProcessor());
        assertNull(codingPc.getGpu());
    }

    @Test
    public void testInvalidComputerIsAccepted() {
        Computer broken = new Computer(null, null);

        assertNull(broken.getProcessor());
    }
}

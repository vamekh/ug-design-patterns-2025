package ge.edu.ug.patterns.creational.builder.computer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

// Builder: parts are set by name, skipped parts are simply not set.
// Director: the "gaming" and "coding" presets are defined once and customised per caller.
class ComputerTest {

    ComputerDirector computerDirector = new ComputerDirector();

    @Test
    public void testCustomComputer() {
        Computer computer = new ComputerBuilder()
                .setProcessor("Intel Core i7")
                .setRam("32GB")
                .setGpu("RTX 4070")
                .build();

        assertEquals("Intel Core i7", computer.getProcessor());
        assertNull(computer.getStorage());
        assertEquals("RTX 4070", computer.getGpu());
    }

    @Test
    public void testGamingPc() {
        Computer gamingPc = computerDirector.getGamingPc()
                .setDisplay("4K")
                .build();

        assertEquals("Intel i5", gamingPc.getProcessor());
        assertEquals("4K", gamingPc.getDisplay());
    }

    @Test
    public void testGamingPcWithOtherDisplay() {
        Computer gamingPc = computerDirector.getGamingPc()
                .setDisplay("2K")
                .build();

        assertEquals("RTX 4070", gamingPc.getGpu());
        assertEquals("2K", gamingPc.getDisplay());
    }

    @Test
    public void testCodingPc() {
        Computer codingPc = computerDirector.getCodingPc()
                .setDisplay("2K")
                .build();

        assertEquals("Intel i9", codingPc.getProcessor());
        assertNull(codingPc.getGpu());
    }

    @Test
    public void testInvalidComputerIsRejected() {
        assertThrows(IllegalStateException.class, () -> new ComputerBuilder().build());
    }
}

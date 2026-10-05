package ge.edu.ug.patterns.behavioral.interpreter.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// The simple shapes work, but only thanks to the order of the split() calls.
// Parentheses are not supported at all, and there is no expression tree we could reuse.
class CalculatorTest {

    @Test
    void testSumAndPower() {
        assertEquals(11.0, Calculator.eval("2 + 3 ^ 2"), 0.001);
    }

    @Test
    void testPrecedence() {
        assertEquals(10.0, Calculator.eval("2 * 3 + 4"), 0.001);
        assertEquals(43.0, Calculator.eval("5 ^ 2 + 6 + 12"), 0.001);
    }

    @Test
    void testPowerIsRightAssociative() {
        assertEquals(512.0, Calculator.eval("2 ^ 3 ^ 2"), 0.001);
    }

    @Test
    void testParenthesesAreNotSupported() {
        assertThrows(UnsupportedOperationException.class, () -> Calculator.eval("(2 + 3) * 4"));
    }

    @Test
    void testInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.eval("2 + abc"));
    }
}

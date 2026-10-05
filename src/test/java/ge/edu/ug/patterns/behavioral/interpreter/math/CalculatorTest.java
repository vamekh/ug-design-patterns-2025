package ge.edu.ug.patterns.behavioral.interpreter.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void testParentheses() {
        assertEquals(20.0, Calculator.eval("(2 + 3) * 4"), 0.001);
        assertEquals(64.0, Calculator.eval("(2 ^ 3) ^ 2"), 0.001);
    }

    @Test
    void testInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.eval("2 + abc"));
        assertThrows(IllegalArgumentException.class, () -> Calculator.eval("(2 + 3"));
    }
}

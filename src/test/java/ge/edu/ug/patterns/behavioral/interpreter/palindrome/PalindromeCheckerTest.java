package ge.edu.ug.patterns.behavioral.interpreter.palindrome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PalindromeCheckerTest {

    @Test
    void testPalindromes() {
        assertTrue(PalindromeChecker.isPalindrome("7"));
        assertTrue(PalindromeChecker.isPalindrome("44"));
        assertTrue(PalindromeChecker.isPalindrome("121"));
        assertTrue(PalindromeChecker.isPalindrome("12321"));
        assertTrue(PalindromeChecker.isPalindrome("123321"));
    }

    @Test
    void testNotPalindromes() {
        assertFalse(PalindromeChecker.isPalindrome("12"));
        assertFalse(PalindromeChecker.isPalindrome("1231"));
        assertFalse(PalindromeChecker.isPalindrome("12341"));
    }

    @Test
    void testNotInTheLanguage() {
        assertFalse(PalindromeChecker.isPalindrome(""));
        assertFalse(PalindromeChecker.isPalindrome("1a1"));
        assertFalse(PalindromeChecker.isPalindrome("aba"));
    }

    @Test
    void testTreeBuiltByHand() {
        // "1 [ 2 3 2 ] 1"  =>  Wrapped(1, Wrapped(2, Digit(3), 2), 1)
        PalindromeExpression tree = new WrappedPalindrome(
                new DigitExpression(0),
                new WrappedPalindrome(new DigitExpression(1), new DigitExpression(2), new DigitExpression(3)),
                new DigitExpression(4));

        assertTrue(tree.interpret(new Context("12321")));
        assertFalse(tree.interpret(new Context("12322")));
    }
}

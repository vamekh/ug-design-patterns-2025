package ge.edu.ug.patterns.behavioral.interpreter.palindrome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// The answers are right, but the language being recognised is only implied by
// index arithmetic in PalindromeChecker; there is no structure matching the grammar.
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
}

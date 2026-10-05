package ge.edu.ug.patterns.behavioral.interpreter.palindrome;

// Validation and the palindrome rule are tangled together with two moving indexes.
// The grammar (single digit, two equal digits, digit + palindrome + same digit)
// is nowhere visible, so changing or extending the language means rewriting this loop.
public class PalindromeChecker {

    public static boolean isPalindrome(String digits) {
        if (digits == null || digits.isEmpty()) {
            return false;
        }
        int i = 0;
        int j = digits.length() - 1;
        while (i <= j) {
            char first = digits.charAt(i);
            char last = digits.charAt(j);
            if (first < '0' || first > '9' || last < '0' || last > '9') {
                return false;
            }
            if (first != last) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

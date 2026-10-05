package ge.edu.ug.patterns.behavioral.interpreter.palindrome;

// Client: builds the syntax tree for the grammar and interprets it on the input
//   <palindrom> ::= <digit> | <digit>[1] <palindrom> <digit>[2] | <digit>[1] <digit>[2]
//   predicate:   digit[1] == digit[2]
//   <digit>     ::= "0" | "1" | ... | "9"
public class PalindromeChecker {

    public static boolean isPalindrome(String digits) {
        if (digits == null || digits.isEmpty()) {
            return false;
        }
        PalindromeExpression expression = build(0, digits.length() - 1);
        return expression.interpret(new Context(digits));
    }

    // picks the grammar alternative that matches the span [from, to]
    static PalindromeExpression build(int from, int to) {
        if (from == to) {
            return new DigitExpression(from);
        }
        if (to - from == 1) {
            return new TwoDigitPalindrome(new DigitExpression(from), new DigitExpression(to));
        }
        return new WrappedPalindrome(new DigitExpression(from), build(from + 1, to - 1), new DigitExpression(to));
    }
}

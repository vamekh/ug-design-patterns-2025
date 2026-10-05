package ge.edu.ug.patterns.behavioral.interpreter.palindrome;

// Non-terminal Expression: <digit>[1] <palindrom> <digit>[2] with digit[1] == digit[2]
public class WrappedPalindrome implements PalindromeExpression {
    private final DigitExpression first;
    private final PalindromeExpression middle;
    private final DigitExpression last;

    public WrappedPalindrome(DigitExpression first, PalindromeExpression middle, DigitExpression last) {
        this.first = first;
        this.middle = middle;
        this.last = last;
    }

    @Override
    public boolean interpret(Context context) {
        return first.interpret(context) && last.interpret(context)
                && first.value(context) == last.value(context)
                && middle.interpret(context);
    }
}

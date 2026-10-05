package ge.edu.ug.patterns.behavioral.interpreter.palindrome;

// Non-terminal Expression: <digit>[1] <digit>[2] with digit[1] == digit[2]
public class TwoDigitPalindrome implements PalindromeExpression {
    private final DigitExpression first;
    private final DigitExpression last;

    public TwoDigitPalindrome(DigitExpression first, DigitExpression last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean interpret(Context context) {
        return first.interpret(context) && last.interpret(context)
                && first.value(context) == last.value(context);
    }
}

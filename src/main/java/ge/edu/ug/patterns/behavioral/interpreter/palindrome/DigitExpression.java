package ge.edu.ug.patterns.behavioral.interpreter.palindrome;

// Terminal Expression: <digit> ::= "0" | ... | "9"  (a single digit is also a <palindrom>)
public class DigitExpression implements PalindromeExpression {
    private final int position;

    public DigitExpression(int position) {
        this.position = position;
    }

    public char value(Context context) {
        return context.charAt(position);
    }

    @Override
    public boolean interpret(Context context) {
        char c = value(context);
        return c >= '0' && c <= '9';
    }
}

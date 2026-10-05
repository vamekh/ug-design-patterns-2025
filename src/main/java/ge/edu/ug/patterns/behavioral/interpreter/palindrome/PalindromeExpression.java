package ge.edu.ug.patterns.behavioral.interpreter.palindrome;

// Abstract Expression: <palindrom>
public interface PalindromeExpression {
    boolean interpret(Context context);
}

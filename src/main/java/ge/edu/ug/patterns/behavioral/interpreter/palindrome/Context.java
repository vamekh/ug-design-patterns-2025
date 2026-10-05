package ge.edu.ug.patterns.behavioral.interpreter.palindrome;

// Context: the sentence being interpreted
public class Context {
    private final String input;

    public Context(String input) {
        this.input = input;
    }

    public char charAt(int position) {
        return input.charAt(position);
    }
}

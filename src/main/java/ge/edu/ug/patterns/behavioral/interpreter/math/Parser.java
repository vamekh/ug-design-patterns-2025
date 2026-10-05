package ge.edu.ug.patterns.behavioral.interpreter.math;

// Builds the expression tree with recursive descent, one method per grammar rule:
//   sum     ::= product ( "+" product )*
//   product ::= power ( "*" power )*
//   power   ::= primary [ "^" power ]          (right-associative)
//   primary ::= number | "(" sum ")"
public class Parser {
    private final String input;
    private int position = 0;

    public Parser(String input) {
        this.input = input.replace(" ", "");
    }

    public MathExpression parse() {
        MathExpression expression = parseSum();
        if (position != input.length()) {
            throw error();
        }
        return expression;
    }

    private MathExpression parseSum() {
        MathExpression left = parseProduct();
        while (accept('+')) {
            left = new SumExpression(left, parseProduct());
        }
        return left;
    }

    private MathExpression parseProduct() {
        MathExpression left = parsePower();
        while (accept('*')) {
            left = new MultiplyExpression(left, parsePower());
        }
        return left;
    }

    private MathExpression parsePower() {
        MathExpression base = parsePrimary();
        if (accept('^')) {
            return new PowerExpression(base, parsePower());
        }
        return base;
    }

    private MathExpression parsePrimary() {
        if (accept('(')) {
            MathExpression inner = parseSum();
            if (!accept(')')) {
                throw error();
            }
            return inner;
        }
        int start = position;
        while (position < input.length()
                && (Character.isDigit(input.charAt(position)) || input.charAt(position) == '.')) {
            position++;
        }
        if (start == position) {
            throw error();
        }
        return new NumberExpression(Double.parseDouble(input.substring(start, position)));
    }

    private boolean accept(char token) {
        if (position < input.length() && input.charAt(position) == token) {
            position++;
            return true;
        }
        return false;
    }

    private IllegalArgumentException error() {
        return new IllegalArgumentException("Cannot evaluate: " + input + " (at position " + position + ")");
    }
}

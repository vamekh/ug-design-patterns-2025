package ge.edu.ug.patterns.behavioral.interpreter.math;

// Grammar rules are hidden in string splitting: precedence only works because "+" is split
// before "*" and "*" before "^". There is no tree to reuse, and parentheses (or any new
// operator) would need yet another round of hacks in this one method.
public class Calculator {

    public static double eval(String input) {
        String expression = input.replace(" ", "");
        if (expression.contains("(") || expression.contains(")")) {
            throw new UnsupportedOperationException("Parentheses are not supported: " + input);
        }
        if (expression.contains("+")) {
            double sum = 0;
            for (String part : expression.split("\\+")) {
                sum += eval(part);
            }
            return sum;
        } else {
            if (expression.contains("*")) {
                double product = 1;
                for (String part : expression.split("\\*")) {
                    product *= eval(part);
                }
                return product;
            } else {
                if (expression.contains("^")) {
                    // "^" is right-associative, so fold the parts from the right
                    String[] parts = expression.split("\\^");
                    double result = Double.parseDouble(parts[parts.length - 1]);
                    for (int i = parts.length - 2; i >= 0; i--) {
                        result = Math.pow(Double.parseDouble(parts[i]), result);
                    }
                    return result;
                }
            }
        }
        try {
            return Double.parseDouble(expression);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Cannot evaluate: " + input);
        }
    }
}

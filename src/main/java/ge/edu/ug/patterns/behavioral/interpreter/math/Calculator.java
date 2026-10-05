package ge.edu.ug.patterns.behavioral.interpreter.math;

// Client: the string is parsed into a tree of MathExpressions, and the tree interprets itself
public class Calculator {

    public static double eval(String input) {
        MathExpression expression = new Parser(input).parse();
        return expression.interpret();
    }
}

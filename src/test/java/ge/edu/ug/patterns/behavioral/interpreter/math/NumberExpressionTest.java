package ge.edu.ug.patterns.behavioral.interpreter.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberExpressionTest {

    @Test
    void testTreeBuiltByHand() {
        // 5 ^ 2 + 6 + 12
        MathExpression five = new NumberExpression(5.0);
        MathExpression sqP5 = new PowerExpression(five, new NumberExpression(2.0));
        MathExpression six = new NumberExpression(6.0);
        MathExpression twelve = new NumberExpression(12.0);

        MathExpression sumExp = new SumExpression(sqP5, six);
        MathExpression sumExpr2 = new SumExpression(sumExp, twelve);

        assertEquals(43.0, sumExpr2.interpret(), 0.001);
    }

    @Test
    void testMultiply() {
        // (2 + 3) * 4
        MathExpression expr = new MultiplyExpression(
                new SumExpression(new NumberExpression(2.0), new NumberExpression(3.0)),
                new NumberExpression(4.0));

        assertEquals(20.0, expr.interpret(), 0.001);
    }
}

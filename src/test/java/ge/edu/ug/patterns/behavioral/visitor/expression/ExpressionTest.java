package ge.edu.ug.patterns.behavioral.visitor.expression;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Both operations work, but each is spread over NumberExpression, AddExpression,
// SubtractExpression and MultiplyExpression. A third operation means editing all four again.
class ExpressionTest {

    @Test
    void testEvaluation() {
        // (3 + 4) * 2  =>  14.0
        Expression expr = new MultiplyExpression(
                new AddExpression(new NumberExpression(3), new NumberExpression(4)),
                new NumberExpression(2)
        );

        assertEquals(14.0, expr.evaluate(), 0.001);
    }

    @Test
    void testPrint() {
        // (10 - 3) * (2 + 1)
        Expression expr = new MultiplyExpression(
                new SubtractExpression(new NumberExpression(10), new NumberExpression(3)),
                new AddExpression(new NumberExpression(2), new NumberExpression(1))
        );

        assertEquals("((10 - 3) * (2 + 1))", expr.print());
    }
}

package ge.edu.ug.patterns.behavioral.visitor.expression;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpressionTest {

    @Test
    void testEvaluation() {
        // (3 + 4) * 2  =>  14.0
        Expression expr = new MultiplyExpression(
                new AddExpression(new NumberExpression(3), new NumberExpression(4)),
                new NumberExpression(2)
        );

        assertEquals(14.0, expr.accept(new EvaluateVisitor()), 0.001);
    }

    @Test
    void testPrint() {
        // (10 - 3) * (2 + 1)
        Expression expr = new MultiplyExpression(
                new SubtractExpression(new NumberExpression(10), new NumberExpression(3)),
                new AddExpression(new NumberExpression(2), new NumberExpression(1))
        );

        assertEquals("((10 - 3) * (2 + 1))", expr.accept(new PrintVisitor()));
    }

    @Test
    void testNewOperationIsJustANewVisitor() {
        // counts the numbers in the tree, no expression class was edited
        ExpressionVisitor<Integer> countNumbers = new ExpressionVisitor<>() {
            public Integer visit(NumberExpression e) {
                return 1;
            }

            public Integer visit(AddExpression e) {
                return e.getLeft().accept(this) + e.getRight().accept(this);
            }

            public Integer visit(SubtractExpression e) {
                return e.getLeft().accept(this) + e.getRight().accept(this);
            }

            public Integer visit(MultiplyExpression e) {
                return e.getLeft().accept(this) + e.getRight().accept(this);
            }
        };
        Expression expr = new MultiplyExpression(
                new SubtractExpression(new NumberExpression(10), new NumberExpression(3)),
                new AddExpression(new NumberExpression(2), new NumberExpression(1))
        );

        assertEquals(4, expr.accept(countNumbers));
    }
}

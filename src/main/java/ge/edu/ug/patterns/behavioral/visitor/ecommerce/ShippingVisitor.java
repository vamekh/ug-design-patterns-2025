package ge.edu.ug.patterns.behavioral.visitor.ecommerce;

// Concrete Visitor: sums up the shipping cost of the visited products
public class ShippingVisitor implements Visitor {
    private double total = 0;

    public double getTotal() {
        return total;
    }

    @Override
    public void visit(Books books) {
        total += 2.0;
    }

    @Override
    public void visit(Clothing clothing) {
        total += 3.0;
    }

    @Override
    public void visit(Electronics electronics) {
        total += 10.0;
    }

    @Override
    public void visit(Furniture furniture) {
        total += 50.0;
    }
}

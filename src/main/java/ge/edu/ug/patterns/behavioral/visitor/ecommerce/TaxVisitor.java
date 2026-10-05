package ge.edu.ug.patterns.behavioral.visitor.ecommerce;

// Concrete Visitor: sums up the taxes of the visited products
public class TaxVisitor implements Visitor {
    private double total = 0;

    public double getTotal() {
        return total;
    }

    @Override
    public void visit(Books books) {
        total += books.getPrice() * 10 / 100;
    }

    @Override
    public void visit(Clothing clothing) {
        total += clothing.getPrice() * 15 / 100;
    }

    @Override
    public void visit(Electronics electronics) {
        total += electronics.getPrice() * 20 / 100;
    }

    @Override
    public void visit(Furniture furniture) {
        total += 0; // furniture is tax free
    }
}

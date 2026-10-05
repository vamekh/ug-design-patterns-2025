package ge.edu.ug.patterns.behavioral.visitor.tourguide;

// Concrete Visitor: the tour guide
public class ExhibitGuidingVisitor extends ExhibitVisitor {
    @Override
    public void visit(Art exhibit) {
        note("The tour guide talks about the painter of " + exhibit.getName() + " and the art era");
    }

    @Override
    public void visit(Artifact exhibit) {
        note("The tour guide talks about the history and significance of " + exhibit.getName());
    }

    @Override
    public void visit(WaxFigure exhibit) {
        note("The tour guide talks about the life of " + exhibit.getName() + " and how the wax figure was made");
    }
}

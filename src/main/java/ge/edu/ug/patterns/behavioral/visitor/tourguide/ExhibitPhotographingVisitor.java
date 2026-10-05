package ge.edu.ug.patterns.behavioral.visitor.tourguide;

// Concrete Visitor: the photographer, added without touching any exhibit class
public class ExhibitPhotographingVisitor extends ExhibitVisitor {
    @Override
    public void visit(Art exhibit) {
        note("The photographer shoots " + exhibit.getName() + " without flash to protect the paint");
    }

    @Override
    public void visit(Artifact exhibit) {
        note("The photographer shoots " + exhibit.getName() + " from every side");
    }

    @Override
    public void visit(WaxFigure exhibit) {
        note("The photographer takes a selfie with " + exhibit.getName());
    }
}

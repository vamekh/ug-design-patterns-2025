package ge.edu.ug.patterns.behavioral.visitor.tourguide;

// Concrete Visitor: the cleaning staff
public class ExhibitCleaningVisitor extends ExhibitVisitor {
    @Override
    public void visit(Art exhibit) {
        note("The cleaning staff carefully cleans the art piece " + exhibit.getName() + ", ensuring no damage is done");
    }

    @Override
    public void visit(Artifact exhibit) {
        note("The cleaning staff carefully cleans the artifact " + exhibit.getName() + ", ensuring no damage is done");
    }

    @Override
    public void visit(WaxFigure exhibit) {
        note("Wax figure " + exhibit.getName() + " is skipped. Cleaning not allowed");
    }
}

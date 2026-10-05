package ge.edu.ug.patterns.behavioral.visitor.tourguide;

import java.util.ArrayList;
import java.util.List;

// Visitor: one visit method per exhibit type; records what the staff member did
public abstract class ExhibitVisitor {
    private final List<String> notes = new ArrayList<>();

    public abstract void visit(Art exhibit);

    public abstract void visit(Artifact exhibit);

    public abstract void visit(WaxFigure exhibit);

    protected void note(String text) {
        notes.add(text);
    }

    public List<String> getNotes() {
        return notes;
    }
}

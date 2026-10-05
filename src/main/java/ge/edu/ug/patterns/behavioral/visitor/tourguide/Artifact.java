package ge.edu.ug.patterns.behavioral.visitor.tourguide;

// Concrete Element
public class Artifact implements Exhibit {
    private final String name;

    public Artifact(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(ExhibitVisitor visitor) {
        visitor.visit(this);
    }
}

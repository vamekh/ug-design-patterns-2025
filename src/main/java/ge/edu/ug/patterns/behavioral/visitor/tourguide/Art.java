package ge.edu.ug.patterns.behavioral.visitor.tourguide;

// Concrete Element
public class Art implements Exhibit {
    private final String name;

    public Art(String name) {
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

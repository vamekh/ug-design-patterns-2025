package ge.edu.ug.patterns.behavioral.visitor.tourguide;

// Every staff activity (cleaning, guiding, ...) is a method on every exhibit.
// Adding "photograph" means editing this interface and Art, Artifact and WaxFigure.
public interface Exhibit {
    String clean();

    String guide();
}

package ge.edu.ug.patterns.behavioral.visitor.tourguide;

// Element: exhibits only accept visitors; activities live in the visitors
public interface Exhibit {
    void accept(ExhibitVisitor visitor);
}

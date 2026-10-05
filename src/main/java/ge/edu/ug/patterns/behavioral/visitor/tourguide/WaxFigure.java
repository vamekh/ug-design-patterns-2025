package ge.edu.ug.patterns.behavioral.visitor.tourguide;

public class WaxFigure implements Exhibit {
    private final String name;

    public WaxFigure(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String clean() {
        return "Wax figure " + name + " is skipped. Cleaning not allowed";
    }

    @Override
    public String guide() {
        return "The tour guide talks about the life of " + name + " and how the wax figure was made";
    }
}

package ge.edu.ug.patterns.behavioral.visitor.tourguide;

public class Art implements Exhibit {
    private final String name;

    public Art(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String clean() {
        return "The cleaning staff carefully cleans the art piece " + name + ", ensuring no damage is done";
    }

    @Override
    public String guide() {
        return "The tour guide talks about the painter of " + name + " and the art era";
    }
}

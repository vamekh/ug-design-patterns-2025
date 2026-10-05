package ge.edu.ug.patterns.behavioral.visitor.tourguide;

public class Artifact implements Exhibit {
    private final String name;

    public Artifact(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String clean() {
        return "The cleaning staff carefully cleans the artifact " + name + ", ensuring no damage is done";
    }

    @Override
    public String guide() {
        return "The tour guide talks about the history and significance of " + name;
    }
}

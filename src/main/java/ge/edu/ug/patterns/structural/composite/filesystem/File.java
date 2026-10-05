package ge.edu.ug.patterns.structural.composite.filesystem;

public class File {
    private final String name;
    private final long size;

    public File(String name, long size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public String print(String indent) {
        return indent + name + " (" + size + " B)\n";
    }
}

package ge.edu.ug.patterns.structural.composite.filesystem;

// Component: the common type for files, folders and shortcuts.
public abstract class FileSystemNode {
    private final String name;

    protected FileSystemNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract long getSize();

    public abstract String print(String indent);

    public FileSystemNode find(String name) {
        return this.name.equals(name) ? this : null;
    }
}

package ge.edu.ug.patterns.structural.composite.filesystem;

// Leaf
public class File extends FileSystemNode {
    private final long size;

    public File(String name, long size) {
        super(name);
        this.size = size;
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public String print(String indent) {
        return indent + getName() + " (" + size + " B)\n";
    }
}

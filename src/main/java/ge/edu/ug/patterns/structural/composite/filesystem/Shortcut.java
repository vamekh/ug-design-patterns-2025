package ge.edu.ug.patterns.structural.composite.filesystem;

// Leaf added later: a link to another node. Takes no space itself.
public class Shortcut extends FileSystemNode {
    private final FileSystemNode target;

    public Shortcut(String name, FileSystemNode target) {
        super(name);
        this.target = target;
    }

    public FileSystemNode getTarget() {
        return target;
    }

    @Override
    public long getSize() {
        return 0;
    }

    @Override
    public String print(String indent) {
        return indent + getName() + " -> " + target.getName() + "\n";
    }
}

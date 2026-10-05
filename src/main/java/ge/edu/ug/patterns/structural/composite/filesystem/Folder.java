package ge.edu.ug.patterns.structural.composite.filesystem;

import java.util.ArrayList;
import java.util.List;

// Composite: holds any FileSystemNode and delegates to its children.
// A new kind of node (e.g. Shortcut) needs no change here.
public class Folder extends FileSystemNode {
    private final List<FileSystemNode> children = new ArrayList<>();

    public Folder(String name) {
        super(name);
    }

    public Folder add(FileSystemNode node) {
        children.add(node);
        return this;
    }

    @Override
    public long getSize() {
        long total = 0;
        for (FileSystemNode child : children) {
            total += child.getSize();
        }
        return total;
    }

    @Override
    public String print(String indent) {
        StringBuilder sb = new StringBuilder(indent + getName() + "/\n");
        for (FileSystemNode child : children) {
            sb.append(child.print(indent + "  "));
        }
        return sb.toString();
    }

    @Override
    public FileSystemNode find(String name) {
        if (getName().equals(name)) {
            return this;
        }
        for (FileSystemNode child : children) {
            FileSystemNode found = child.find(name);
            if (found != null) {
                return found;
            }
        }
        return null;
    }
}

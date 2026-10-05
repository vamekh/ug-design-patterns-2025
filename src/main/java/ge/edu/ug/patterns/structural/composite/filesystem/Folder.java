package ge.edu.ug.patterns.structural.composite.filesystem;

import java.util.ArrayList;
import java.util.List;

// PROBLEM: Folder keeps files and sub-folders in two separate lists, so every
// operation (getSize, print, find) needs two loops and special-cases each type.
// Adding a new kind of entry (e.g. a Shortcut) means a third list, a third add
// method and a third loop in every operation of this class.
public class Folder {
    private final String name;
    private final List<File> files = new ArrayList<>();
    private final List<Folder> folders = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Folder addFile(File file) {
        files.add(file);
        return this;
    }

    public Folder addFolder(Folder folder) {
        folders.add(folder);
        return this;
    }

    public long getSize() {
        long total = 0;
        for (File file : files) {
            total += file.getSize();
        }
        for (Folder folder : folders) {
            total += folder.getSize();
        }
        return total;
    }

    public String print(String indent) {
        StringBuilder sb = new StringBuilder(indent + name + "/\n");
        for (Folder folder : folders) {
            sb.append(folder.print(indent + "  "));
        }
        for (File file : files) {
            sb.append(file.print(indent + "  "));
        }
        return sb.toString();
    }

    // Returns Object because a match can be a File or a Folder - callers must instanceof.
    public Object find(String name) {
        if (this.name.equals(name)) {
            return this;
        }
        for (File file : files) {
            if (file.getName().equals(name)) {
                return file;
            }
        }
        for (Folder folder : folders) {
            Object found = folder.find(name);
            if (found != null) {
                return found;
            }
        }
        return null;
    }
}

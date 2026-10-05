package ge.edu.ug.patterns.structural.composite.filesystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// PROBLEM: File and Folder share no common type. Building the tree needs addFile/addFolder,
// find() returns Object, and the client must use instanceof to know what it got back.
// There is no way to add a Shortcut without editing Folder (new list, new add, new loops).
class FileSystemTest {

    private Folder buildTree() {
        Folder src = new Folder("src")
                .addFile(new File("Main.java", 1200))
                .addFile(new File("Util.java", 800));
        Folder docs = new Folder("docs")
                .addFile(new File("readme.md", 300));
        return new Folder("project")
                .addFolder(src)
                .addFolder(docs)
                .addFile(new File("pom.xml", 700));
    }

    @Test
    void nestedTreeSize() {
        assertEquals(3000, buildTree().getSize());
    }

    @Test
    void printedTree() {
        String expected = """
                project/
                  src/
                    Main.java (1200 B)
                    Util.java (800 B)
                  docs/
                    readme.md (300 B)
                  pom.xml (700 B)
                """;
        assertEquals(expected, buildTree().print(""));
    }

    @Test
    void clientMustCheckTypeOfFoundEntry() {
        Object found = buildTree().find("Util.java");
        // The client has to know every concrete type to do anything with the result.
        long size;
        if (found instanceof File) {
            size = ((File) found).getSize();
        } else if (found instanceof Folder) {
            size = ((Folder) found).getSize();
        } else {
            size = -1;
        }
        assertEquals(800, size);
    }
}

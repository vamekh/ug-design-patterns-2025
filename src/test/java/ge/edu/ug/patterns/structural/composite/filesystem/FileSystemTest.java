package ge.edu.ug.patterns.structural.composite.filesystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileSystemTest {

    private Folder buildTree() {
        Folder src = new Folder("src")
                .add(new File("Main.java", 1200))
                .add(new File("Util.java", 800));
        Folder docs = new Folder("docs")
                .add(new File("readme.md", 300));
        return new Folder("project")
                .add(src)
                .add(docs)
                .add(new File("pom.xml", 700));
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
    void clientTreatsEveryNodeUniformly() {
        FileSystemNode found = buildTree().find("Util.java");
        assertEquals(800, found.getSize());
        assertEquals(1200 + 800, buildTree().find("src").getSize());
        assertNull(buildTree().find("missing.txt"));
    }

    @Test
    void addingShortcutNeedsNoChangeInFolder() {
        Folder project = buildTree();
        FileSystemNode main = project.find("Main.java");
        Folder desktop = new Folder("desktop").add(new Shortcut("Main.lnk", main));
        project.add(desktop);

        assertEquals(3000, project.getSize()); // shortcuts take no space
        assertTrue(project.print("").contains("    Main.lnk -> Main.java\n"));
        assertSame(main, ((Shortcut) project.find("Main.lnk")).getTarget());
    }
}

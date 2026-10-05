package ge.edu.ug.patterns.structural.proxy.imageprocessor;

import ge.edu.ug.testutil.ConsoleCapture;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// PROBLEM: opening a gallery of 5 images loads all 5 from disk,
// although the user displays only one of them.
class GalleryTest {

    List<String> paths = List.of("cat.jpg", "dog.jpg", "sea.jpg", "city.jpg", "forest.jpg");

    @Test
    public void testOpeningGalleryLoadsEveryImage() {
        int before = DiskImageProcessor.getLoadCount();

        new Gallery(paths);

        assertEquals(before + 5, DiskImageProcessor.getLoadCount());
    }

    @Test
    public void testDisplayingOneImageStillLoadedAll() {
        int before = DiskImageProcessor.getLoadCount();

        Gallery gallery = new Gallery(paths);
        String out = ConsoleCapture.run(() -> gallery.display(1));

        assertTrue(out.contains("pixels of dog.jpg"));
        assertEquals(before + 5, DiskImageProcessor.getLoadCount());
    }
}

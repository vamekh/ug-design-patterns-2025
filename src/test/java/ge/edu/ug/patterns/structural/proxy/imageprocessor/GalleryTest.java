package ge.edu.ug.patterns.structural.proxy.imageprocessor;

import ge.edu.ug.testutil.ConsoleCapture;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Virtual Proxy: the gallery holds cheap proxies; an image is loaded from disk
// only when it is displayed for the first time, and only once.
class GalleryTest {

    List<String> paths = List.of("cat.jpg", "dog.jpg", "sea.jpg", "city.jpg", "forest.jpg");

    @Test
    public void testOpeningGalleryLoadsNothing() {
        int before = DiskImageProcessor.getLoadCount();

        new Gallery(paths);

        assertEquals(before, DiskImageProcessor.getLoadCount());
    }

    @Test
    public void testDisplayingOneImageLoadsOnlyThatImage() {
        int before = DiskImageProcessor.getLoadCount();

        Gallery gallery = new Gallery(paths);
        String out = ConsoleCapture.run(() -> gallery.display(1));

        assertTrue(out.contains("pixels of dog.jpg"));
        assertEquals(before + 1, DiskImageProcessor.getLoadCount());
    }

    @Test
    public void testProxyLoadsOnlyOnce() {
        int before = DiskImageProcessor.getLoadCount();

        ImageProcessor image = new DiskImageProcessorProxy("cat.jpg");
        image.display();
        String out = ConsoleCapture.run(image::display);

        assertTrue(out.contains("pixels of cat.jpg"));
        assertEquals(before + 1, DiskImageProcessor.getLoadCount());
    }
}

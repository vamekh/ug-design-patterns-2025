package ge.edu.ug.patterns.structural.proxy.imageprocessor;

// Real Subject: loads the image from disk as soon as it is created
public class DiskImageProcessor implements ImageProcessor {
    // counts expensive disk loads, so tests can see how many happened
    private static int loadCount = 0;

    private String imageContent;

    public DiskImageProcessor(String path) {
        System.out.println("ImageProcessor created (real)");
        loadFromDisk(path); // expensive operation happens here
    }

    public static int getLoadCount() {
        return loadCount;
    }

    @Override
    public void display() {
        System.out.println("The image content is: " + imageContent);
    }

    private void loadFromDisk(String path) {
        System.out.println("Loading " + path + " from disk...");
        loadCount++;
        imageContent = "pixels of " + path;
    }
}

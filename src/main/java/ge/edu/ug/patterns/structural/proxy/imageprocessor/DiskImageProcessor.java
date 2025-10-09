package ge.edu.ug.patterns.structural.proxy.imageprocessor;

public class DiskImageProcessor implements ImageProcessor {
    String imageContent;

    public DiskImageProcessor(String path) {
        System.out.println("ImageProcessor created (real)");
        loadFromDisk(path); // Expensive operation happens here
    }

    @Override
    public void display() {
        System.out.println("The image content is: " + imageContent);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading " + fileName + " from disk...");
        // Simulate a delay for a heavy operation
        imageContent = "Cute Kitten";
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

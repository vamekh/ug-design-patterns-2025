package ge.edu.ug.patterns.structural.proxy.imageprocessor;

// Virtual Proxy: same interface as the real image, loads it from disk only on the first display()
public class DiskImageProcessorProxy implements ImageProcessor {

    private final String path;

    private DiskImageProcessor diskImageProcessor;

    public DiskImageProcessorProxy(String path) {
        System.out.println("ImageProcessor created (proxy)");
        this.path = path;
    }

    @Override
    public void display() {
        if (diskImageProcessor == null) {
            diskImageProcessor = new DiskImageProcessor(path);
        }
        diskImageProcessor.display();
    }
}

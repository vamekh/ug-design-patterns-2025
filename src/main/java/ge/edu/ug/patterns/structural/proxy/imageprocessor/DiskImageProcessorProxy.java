package ge.edu.ug.patterns.structural.proxy.imageprocessor;

public class DiskImageProcessorProxy implements ImageProcessor {

    private String path;

    private DiskImageProcessor diskImageProcessor;

    public DiskImageProcessorProxy(String path) {
        System.out.println("ImageProcessor created (proxy)");
        this.path = path;
    }

    @Override
    public void display() {
        this.diskImageProcessor = new DiskImageProcessor("image.jpg");
        this.diskImageProcessor.display();
    }
}

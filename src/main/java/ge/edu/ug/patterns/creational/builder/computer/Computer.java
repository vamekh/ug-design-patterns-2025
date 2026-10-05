package ge.edu.ug.patterns.creational.builder.computer;

// PROBLEM: telescoping constructors. Every new optional part (gpu, display...)
// means yet another constructor, and callers must remember the argument order
// and pass null for the parts they do not want: new Computer("i9", "16GB", null, null).
public class Computer {
    private final String processor;
    private final String ram;
    private final String storage;
    private final String display;
    private final String gpu;

    public Computer(String processor, String ram) {
        this(processor, ram, null);
    }

    public Computer(String processor, String ram, String storage) {
        this(processor, ram, storage, null);
    }

    public Computer(String processor, String ram, String storage, String display) {
        this(processor, ram, storage, display, null);
    }

    public Computer(String processor, String ram, String storage, String display, String gpu) {
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
        this.display = display;
        this.gpu = gpu;
    }

    public String getProcessor() {
        return processor;
    }

    public String getRam() {
        return ram;
    }

    public String getStorage() {
        return storage;
    }

    public String getDisplay() {
        return display;
    }

    public String getGpu() {
        return gpu;
    }
}

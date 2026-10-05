package ge.edu.ug.patterns.creational.builder.computer;

// Product: immutable, created only through ComputerBuilder
public class Computer {
    private final String processor;
    private final String ram;
    private final String storage;
    private final String display;
    private final String gpu;

    Computer(String processor, String ram, String storage, String display, String gpu) {
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

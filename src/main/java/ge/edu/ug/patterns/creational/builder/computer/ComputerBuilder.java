package ge.edu.ug.patterns.creational.builder.computer;

// Builder: named, optional steps; validates required parts in build()
public class ComputerBuilder {
    private String processor;
    private String ram;
    private String storage;
    private String display;
    private String gpu;

    public ComputerBuilder setProcessor(String processor) {
        this.processor = processor;
        return this;
    }

    public ComputerBuilder setRam(String ram) {
        this.ram = ram;
        return this;
    }

    public ComputerBuilder setStorage(String storage) {
        this.storage = storage;
        return this;
    }

    public ComputerBuilder setDisplay(String display) {
        this.display = display;
        return this;
    }

    public ComputerBuilder setGpu(String gpu) {
        this.gpu = gpu;
        return this;
    }

    public Computer build() {
        if (processor == null || ram == null) {
            throw new IllegalStateException("processor and ram are required");
        }
        return new Computer(processor, ram, storage, display, gpu);
    }
}

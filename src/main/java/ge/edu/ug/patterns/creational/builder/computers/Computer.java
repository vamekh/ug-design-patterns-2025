package ge.edu.ug.patterns.creational.builder.computers;

public class Computer {
    String processor;
    String ram;
    String storage;
    String display;

    public Computer(String processor, String ram, String storage, String display) {
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
        this.display = display;
    }
}

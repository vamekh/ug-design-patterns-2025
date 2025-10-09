package ge.edu.ug.patterns.creational.builder.computers;

public class ComputerBuilder {
    private String processor = null;
    private String ram = null;
    private String storage = null;
    private String display = null;

    public Computer build(){
        return new Computer(processor, ram, storage, display);
    }

    public ComputerBuilder setProcessor(String processor){
        this.processor = processor;
        return this;
    }

    public ComputerBuilder setRam(String ram){
        this.ram = ram;
        return this;
    }

    public ComputerBuilder setStorage(String storage){
        this.storage = storage;
        return this;
    }

    public ComputerBuilder setDisplay(String display){
        this.display = display;
        return this;
    }
}

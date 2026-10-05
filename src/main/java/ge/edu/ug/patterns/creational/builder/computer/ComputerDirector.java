package ge.edu.ug.patterns.creational.builder.computer;

// Director: knows the preset build steps, so they live in one place
public class ComputerDirector {

    public ComputerBuilder getGamingPc() {
        return new ComputerBuilder()
                .setProcessor("Intel i5")
                .setRam("16GB")
                .setStorage("1TB")
                .setGpu("RTX 4070");
    }

    public ComputerBuilder getCodingPc() {
        return new ComputerBuilder()
                .setProcessor("Intel i9")
                .setRam("16GB")
                .setStorage("1TB");
    }
}

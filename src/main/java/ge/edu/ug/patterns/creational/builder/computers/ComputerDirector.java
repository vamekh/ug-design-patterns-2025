package ge.edu.ug.patterns.creational.builder.computers;

public class ComputerDirector {
    public ComputerBuilder getGamingPc(){
        ComputerBuilder builder = new ComputerBuilder();
        builder.setProcessor("Intel i5");
        builder.setRam("16GB");
        builder.setStorage("1TB");
        return builder;
    }


    public ComputerBuilder getCodingPc(){
        ComputerBuilder builder = new ComputerBuilder();
        builder.setProcessor("Intel i9");
        builder.setRam("16GB");
        builder.setStorage("1TB");
        return builder;
    }
}

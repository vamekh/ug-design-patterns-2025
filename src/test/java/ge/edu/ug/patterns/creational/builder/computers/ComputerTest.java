package ge.edu.ug.patterns.creational.builder.computers;

import org.junit.jupiter.api.Test;

class ComputerTest {

    ComputerDirector computerDirector = new ComputerDirector();

    @Test
    public void testComputerBuilder(){
        ComputerBuilder computerBuilder = new ComputerBuilder();
        computerBuilder
                .setDisplay("4k")
                .setRam("32GB")
                .setStorage("2TB")
                .setProcessor("Intel Core i7");

        Computer computer = computerBuilder.build();


        ComputerBuilder gamingPcBuilder = computerDirector.getGamingPc();
        gamingPcBuilder.setDisplay("4K");
        Computer gamingPc = gamingPcBuilder.build();


        ComputerBuilder codingPcBuilder = computerDirector.getGamingPc();
        codingPcBuilder.setDisplay("2K");
        Computer codingPc = codingPcBuilder.build();


    }

}

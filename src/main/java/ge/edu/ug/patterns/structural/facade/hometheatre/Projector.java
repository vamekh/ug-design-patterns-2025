package ge.edu.ug.patterns.structural.facade.hometheatre;

public class Projector {
    public void off(){
        System.out.println("Projector off");
    }

    public void on(){
        System.out.println("Projector on");
    }

    public void setInput(String input){
        System.out.println("Projector input set to " + input);
    }


}

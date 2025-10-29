package ge.edu.ug.patterns.structural.facade.hometheatre;

public class DvdPlayer {
    public void play(String film) {
        System.out.println("DvdPlayer playing " + film);
    }
    public void on(){
        System.out.println("DvdPlayer on");
    }
    public void off(){
        System.out.println("DvdPlayer off");
    }
}

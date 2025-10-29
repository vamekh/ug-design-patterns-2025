package ge.edu.ug.patterns.structural.facade.hometheatre;

public class SoundSystem {
    public void on(){
        System.out.println("Sound system on");
    }
    public void off(){
        System.out.println("Sound system off");
    }
    public void setVolume(int level){
        System.out.println("Sound system set volume to " + level);
    }
}

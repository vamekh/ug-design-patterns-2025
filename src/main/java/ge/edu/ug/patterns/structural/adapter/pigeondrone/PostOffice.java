package ge.edu.ug.patterns.structural.adapter.pigeondrone;

// Client: only knows the DronePost interface
public class PostOffice {
    private final DronePost dronePost;

    public PostOffice(DronePost dronePost) {
        this.dronePost = dronePost;
    }

    public void deliver(Object pckg, String address, String message) {
        dronePost.deliver(pckg, address, message);
    }
}

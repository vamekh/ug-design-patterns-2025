package ge.edu.ug.patterns.structural.adapter.pigeondrone;

public class PostOffice implements DronePost {
    DronePost dronePost;
    public PostOffice(DronePost dronePost) {
        this.dronePost = dronePost;
    }

    public void deliver(Object pckg, String address, String message) {
        this.dronePost.deliver(pckg, address, message);
    }
}

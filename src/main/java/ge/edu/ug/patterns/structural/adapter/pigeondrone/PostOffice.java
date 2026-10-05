package ge.edu.ug.patterns.structural.adapter.pigeondrone;

// PostOffice knows both delivery interfaces: one field and one constructor per carrier type,
// plus a branch in deliver() that translates the call for birds. Every new incompatible
// carrier (a courier API, a truck service...) adds another field, constructor and if.
public class PostOffice {
    private DronePost dronePost;
    private BirdPost birdPost;

    public PostOffice(DronePost dronePost) {
        this.dronePost = dronePost;
    }

    public PostOffice(BirdPost birdPost) {
        this.birdPost = birdPost;
    }

    public void deliver(Object pckg, String address, String message) {
        if (birdPost != null) {
            // pigeons cannot carry packages: the package is silently dropped
            birdPost.deliver(address, message);
        } else {
            dronePost.deliver(pckg, address, message);
        }
    }
}

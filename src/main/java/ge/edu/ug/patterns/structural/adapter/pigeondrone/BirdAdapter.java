package ge.edu.ug.patterns.structural.adapter.pigeondrone;

// Adapter: looks like a DronePost, delegates to a BirdPost
public class BirdAdapter implements DronePost {
    private final BirdPost birdPost;

    public BirdAdapter(BirdPost birdPost) {
        this.birdPost = birdPost;
    }

    @Override
    public void deliver(Object pckg, String address, String message) {
        // pigeons cannot carry packages: only the message is delivered
        System.out.println("BirdAdapter deliver: " + message + ". თქვენი დიდი ხათრი მააააქ, მაგრამ ამანათს ვერ მივიტან!");
        birdPost.deliver(address, message);
    }
}

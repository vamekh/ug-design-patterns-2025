package ge.edu.ug.patterns.structural.adapter.pigeondrone;

public class BirdAdapter implements DronePost {
    private BirdPost birdPost;

    public BirdAdapter(BirdPost birdPost) {
        this.birdPost = birdPost;
    }

    @Override
    public void deliver(Object pckg, String address, String message) {
        System.out.println("BirdAdapter deliver: " + message + ". თქვენი დიდი ხათრი მააააქ, მაგრამ ამანათს ვერ მივიტან!");
        this.birdPost.deliver(address, message);
    }
}

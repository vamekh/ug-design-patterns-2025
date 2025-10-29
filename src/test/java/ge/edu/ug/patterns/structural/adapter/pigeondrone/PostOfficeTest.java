package ge.edu.ug.patterns.structural.adapter.pigeondrone;

import org.junit.jupiter.api.Test;

class PostOfficeTest {
    @Test
    public void test() {
        PostOffice postOffice = new PostOffice(new FastDrone());
        postOffice.deliver("Kanchi", "Kazbeg", "Glaciers melting fast...");

        PostOffice fakeDronePost = new PostOffice(
                new BirdAdapter(new PigeonDelivery())
        );
        fakeDronePost.deliver("Khash", "It is khash time!", "Ksani str.");
    }

}

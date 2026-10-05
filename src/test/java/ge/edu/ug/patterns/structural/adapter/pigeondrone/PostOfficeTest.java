package ge.edu.ug.patterns.structural.adapter.pigeondrone;

import ge.edu.ug.testutil.ConsoleCapture;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// PostOffice only talks to DronePost; BirdAdapter makes the pigeon service fit that interface.
class PostOfficeTest {

    @Test
    void droneDeliversPackage() {
        PostOffice postOffice = new PostOffice(new FastDrone());

        String out = ConsoleCapture.run(() -> postOffice.deliver("Kanchi", "Kazbegi", "Glaciers melting fast..."));

        assertTrue(out.contains("FastDrone deliver: Glaciers melting fast... Package includes: Kanchi. address: Kazbegi"));
    }

    @Test
    void pigeonDeliversMessageOnly() {
        PostOffice postOffice = new PostOffice(new BirdAdapter(new PigeonDelivery()));

        String out = ConsoleCapture.run(() -> postOffice.deliver("Khash", "Ksani str.", "It is khash time!"));

        assertTrue(out.contains("Delivering It is khash time! to Ksani str."));
        assertFalse(out.contains("Khash"));
    }
}

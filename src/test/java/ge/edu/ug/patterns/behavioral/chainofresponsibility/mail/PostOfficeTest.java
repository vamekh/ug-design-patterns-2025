package ge.edu.ug.patterns.behavioral.chainofresponsibility.mail;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// PROBLEM: every scenario goes through the whole PostOffice.accept(); there is
// no way to run a single check, or to build a different set of checks, without editing it.
class PostOfficeTest {

    private static final String STAMP = "22 year anniversary of UG";
    private static final String UG = "Kostava str. 77, Tbilisi";
    private static final String HOME = "Rustaveli ave. 1, Tbilisi";

    private final XRayScanner noBomb = envelope -> false;

    @Test
    void acceptsValidEnvelope() {
        PostOffice postOffice = new PostOffice(noBomb);

        assertTrue(postOffice.accept(new Envelope(STAMP, UG, HOME, "Please study for your good!")));
    }

    @Test
    void rejectsEnvelopeWithoutSender() {
        PostOffice postOffice = new PostOffice(noBomb);

        assertFalse(postOffice.accept(new Envelope(STAMP, UG, "", "Please study for your good!")));
    }

    @Test
    void rejectsEnvelopeWithEmptyContent() {
        PostOffice postOffice = new PostOffice(noBomb);

        assertFalse(postOffice.accept(new Envelope(STAMP, UG, HOME, " ")));
    }

    @Test
    void rejectsEnvelopeWhenScannerDetectsBomb() {
        PostOffice postOffice = new PostOffice(envelope -> true);

        assertFalse(postOffice.accept(new Envelope(STAMP, UG, HOME, "Tick tock")));
    }

    @Test
    void invalidStampStopsBeforeTheScanner() {
        int[] scans = {0};
        PostOffice postOffice = new PostOffice(envelope -> {
            scans[0]++;
            return false;
        });

        assertFalse(postOffice.accept(new Envelope("Fake stamp", UG, HOME, "Hello")));
        assertEquals(0, scans[0]);
    }
}

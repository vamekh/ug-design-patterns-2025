package ge.edu.ug.patterns.structural.decorator.notifier;

import ge.edu.ug.testutil.ConsoleCapture;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Channels are chosen with positional booleans: new Notifier("x", true, false) says nothing
// about what it does, and every new channel adds another flag to every call site.
class NotifierTest {

    @Test
    void sendsToEmailInstagramAndFacebook() {
        Notifier notifier = new Notifier("vamexinar", true, true);

        String out = ConsoleCapture.run(() -> notifier.send("Achtung!"));

        int email = out.indexOf("Notifying vamexinar message to vamexinar@gmail.com message: Achtung!");
        int insta = out.indexOf("Sending to Instagram as: vamexinar_insta message: Achtung!");
        int fb = out.indexOf("Sending to Facebook as: vamexinar_fb message: Achtung!");
        assertTrue(email >= 0 && email < insta && insta < fb, out);
    }

    @Test
    void emailOnly() {
        Notifier notifier = new Notifier("vamexinar", false, false);

        String out = ConsoleCapture.run(() -> notifier.send("Hi"));

        assertTrue(out.contains("vamexinar@gmail.com"));
        assertFalse(out.contains("Facebook"));
        assertFalse(out.contains("Instagram"));
    }
}

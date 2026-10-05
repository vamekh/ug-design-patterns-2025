package ge.edu.ug.patterns.structural.decorator.notifier;

import ge.edu.ug.testutil.ConsoleCapture;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Channels are added by wrapping; the wrapping order is the sending order.
class NotifierTest {

    @Test
    void sendsToEmailInstagramAndFacebook() {
        INotifier notifier = new FacebookDecorator(new InstagramDecorator(new Notifier("vamexinar")));

        String out = ConsoleCapture.run(() -> notifier.send("Achtung!"));

        int email = out.indexOf("Notifying vamexinar message to vamexinar@gmail.com message: Achtung!");
        int insta = out.indexOf("Sending to Instagram as: vamexinar_insta message: Achtung!");
        int fb = out.indexOf("Sending to Facebook as: vamexinar_fb message: Achtung!");
        assertTrue(email >= 0 && email < insta && insta < fb, out);
    }

    @Test
    void emailOnly() {
        INotifier notifier = new Notifier("vamexinar");

        String out = ConsoleCapture.run(() -> notifier.send("Hi"));

        assertTrue(out.contains("vamexinar@gmail.com"));
        assertFalse(out.contains("Facebook"));
        assertFalse(out.contains("Instagram"));
    }

    @Test
    void decoratorsKeepTheWrappedUsername() {
        INotifier notifier = new InstagramDecorator(new Notifier("nino"));
        assertEquals("nino", notifier.getUsername());
    }
}

package ge.edu.ug.patterns.structural.decorator.notifier;

import org.junit.jupiter.api.Test;

class NotifierTest {
    @Test
    public void testNotifier() {
        INotifier notifier = new FacebookDecorator(new InstaNotifier(new Notifier("vamexinar")));
        notifier.send("Achtung!");
    }

}

package ge.edu.ug.solid.dip.notifications;

import org.junit.jupiter.api.Test;

import java.util.List;

class NotificationManagerTest {
    //  * 1. High-level NotificationManager depends on abstraction (presumably NotificationService interface)
    // * 2. Low-level SmsService and EmailService depend on the same abstraction
    // * 3. Services can be switched at runtime due to loose coupling through abstraction

    @Test
    public void testNotificationManager() {
        List<String> recipients = List.of("Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides");

        NotificationManager manager = new NotificationManager(new SmsService());

        recipients.forEach(recipient -> manager.notify(recipient, "Good news", "SOLID principals are eternal!"));

        manager.setSenderService(new EmailService());
        recipients.forEach(recipient -> manager.notify(recipient, "Nice to know", "Design patterns are awesome!"));
    }
}

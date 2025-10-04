package ge.edu.ug.solid.dip.notifications;

import org.junit.jupiter.api.Test;

import java.util.List;

class NotificationManagerTest {
    // This code violates DIP (Dependency Inversion Principle) because:
    // 1. NotificationManager depends directly on concrete SmsService class instead of an abstraction
    // 2. High-level NotificationManager is tightly coupled to low-level SmsService implementation
    // 3. This makes it difficult to swap notification methods (e.g., email, push) without modifying NotificationManager

    @Test
    public void testNotificationManager() {
        List<String> recipients = List.of("Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides");

        SmsService smsService = new SmsService();
        NotificationManager manager = new NotificationManager(smsService);

        recipients.forEach(recipient -> manager.notify(recipient, "Hello", "Welcome to the company!"));
    }

}

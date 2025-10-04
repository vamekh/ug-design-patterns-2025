package ge.edu.ug.solid.dip.notifications;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NotificationManagerTest {
    //  * 1. High-level NotificationManager depends on abstraction (presumably NotificationService interface)
    // * 2. Low-level SmsService and EmailService depend on the same abstraction
    // * 3. Services can be switched at runtime due to loose coupling through abstraction

    @Test
    public void testNotificationManager() {
        List<String> recipients = List.of("Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides");

        NotificationManager manager = new NotificationManager(new SmsService());

        List<String> sms = recipients.stream().map(recipient -> manager.send(recipient, "Good news", "SOLID principles are eternal!")).toList();
        assertEquals("\tRecipient: Erich Gamma\n\tMessage: Good news↵SOLID principles are eternal!\n", sms.get(0));
        assertEquals(4, sms.size());

        manager.setSenderService(new EmailService());
        List<String> emails = recipients.stream().map(recipient -> manager.send(recipient, "Nice to know", "Design patterns are awesome!")).toList();
        assertEquals("\tRecipient: Richard Helm\n\tSubject: Nice to know\n\tBody: Design patterns are awesome!\n", emails.get(1));

        manager.setSenderService(new MmsService());
        List<String> mms = recipients.stream().map(recipient -> manager.send(recipient, "Picture this", "A new channel, zero changes in NotificationManager")).toList();
        assertEquals("\tRecipient: John Vlissides\n\tTitle: Picture this\n\tText: A new channel, zero changes in NotificationManager\n\tAttachment: banner.png\n", mms.get(3));
    }

    @Test
    public void managerUsesWhicheverServiceItIsGiven() {
        // A recording fake: possible only because NotificationManager depends on the abstraction
        List<String> sent = new ArrayList<>();
        NotificationService fake = (recipient, title, text) -> {
            String message = recipient + "|" + title + "|" + text;
            sent.add(message);
            return message;
        };
        NotificationManager manager = new NotificationManager(fake);

        manager.send("Erich Gamma", "Hi", "Test");

        assertEquals(List.of("Erich Gamma|Hi|Test"), sent);
    }
}

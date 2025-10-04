package ge.edu.ug.solid.dip.notifications;

public class EmailService implements NotificationService {
    @Override
    public void notify(String recipient, String title, String text) {
        String eLetter = String.format("\tRecipient: %s\n\tSubject: %s\n\tBody: %s\n", recipient, title, text);
        System.out.printf("Sending email...\n%s\n", eLetter);
    }
}

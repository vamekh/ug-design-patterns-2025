package ge.edu.ug.solid.dip.notifications;

public class SmsNotification {
    String recipient;
    String message;

    public SmsNotification(String recipient, String title, String message) {
        this.recipient = recipient;
        this.message = title + "\n" + message;
    }

    @Override
    public String toString() {
        return String.format("\tRecipient: %s\tMessage: %s", recipient, message.replace("\n", "↵"));
    }
}

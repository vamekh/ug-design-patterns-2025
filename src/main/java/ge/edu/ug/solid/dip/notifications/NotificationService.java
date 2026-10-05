package ge.edu.ug.solid.dip.notifications;

public interface NotificationService {
    // Sends the notification and returns the formatted message that was sent
    String send(String recipient, String title, String text);
}

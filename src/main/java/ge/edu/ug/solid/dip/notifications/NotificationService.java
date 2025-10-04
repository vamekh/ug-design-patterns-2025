package ge.edu.ug.solid.dip.notifications;

public interface NotificationService {
    void notify(String recipient, String title, String text);
}

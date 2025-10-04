package ge.edu.ug.solid.dip.notifications;

public class NotificationManager {
    private NotificationService senderService;

    public NotificationManager(NotificationService senderService) {
        this.senderService = senderService;
    }

    void notify(String recipient, String title, String text) {
        senderService.notify(recipient, title, text);
    }

    void setSenderService(NotificationService senderService) {
        this.senderService = senderService;
    }
}

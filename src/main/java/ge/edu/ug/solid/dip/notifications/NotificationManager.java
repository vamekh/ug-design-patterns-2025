package ge.edu.ug.solid.dip.notifications;

public class NotificationManager {
    private NotificationService senderService;

    public NotificationManager(NotificationService senderService) {
        this.senderService = senderService;
    }

    public String send(String recipient, String title, String text) {
        return senderService.send(recipient, title, text);
    }

    public void setSenderService(NotificationService senderService) {
        this.senderService = senderService;
    }
}

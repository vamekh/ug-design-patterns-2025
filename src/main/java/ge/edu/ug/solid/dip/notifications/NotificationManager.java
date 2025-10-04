package ge.edu.ug.solid.dip.notifications;

public class NotificationManager {
    SmsService smsService;

    public NotificationManager(SmsService smsService) {
        this.smsService = smsService;
    }

    void notify(String recipient, String title, String message) {
        smsService.send(recipient, title, message);
    }
}

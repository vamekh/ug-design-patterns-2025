package ge.edu.ug.solid.dip.notifications;

public class SmsService {
    public void send(String recipient, String title, String message) {
        SmsNotification sms = new SmsNotification(recipient, title, message);
        System.out.printf("Sending sms...\n%s\n", sms);
    }
}

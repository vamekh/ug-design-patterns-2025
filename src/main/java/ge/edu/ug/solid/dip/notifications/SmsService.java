package ge.edu.ug.solid.dip.notifications;

public class SmsService implements NotificationService {
    @Override
    public void notify(String recipient, String title, String text) {
        String smsBody = title + "\n" + text;
        String sms = String.format("\tRecipient: %s\n\tMessage: %s\n", recipient, smsBody.replace("\n", "↵"));
        System.out.printf("Sending sms...\n%s\n", sms);
    }
}

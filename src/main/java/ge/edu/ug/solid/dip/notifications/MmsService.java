package ge.edu.ug.solid.dip.notifications;

// Added later: NotificationManager is not modified, it only knows the NotificationService abstraction
public class MmsService implements NotificationService {
    @Override
    public String send(String recipient, String title, String text) {
        String mms = String.format("\tRecipient: %s\n\tTitle: %s\n\tText: %s\n\tAttachment: banner.png\n", recipient, title, text);
        System.out.printf("Sending mms...\n%s\n", mms);
        return mms;
    }
}

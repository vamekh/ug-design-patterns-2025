package ge.edu.ug.patterns.structural.decorator.notifier;

// One class knows every channel: a boolean flag per channel and an if per flag in send().
// Adding SMS or Slack means a new constructor parameter, a new field and a new branch here,
// and every caller has to pass a growing list of true/false values.
public class Notifier {
    private final DatabaseService databaseService;
    private final String username;
    private final boolean sendFacebook;
    private final boolean sendInstagram;

    public Notifier(String username, boolean sendFacebook, boolean sendInstagram) {
        this.username = username;
        this.sendFacebook = sendFacebook;
        this.sendInstagram = sendInstagram;
        this.databaseService = new DatabaseService();
    }

    public void send(String message) {
        String email = databaseService.getMailFromUsername(username);
        System.out.println("Notifying " + getUsername() + " message to " + email + " message: " + message);

        if (sendInstagram) {
            String insta = databaseService.getInsta(getUsername());
            System.out.println("Sending to Instagram as: " + insta + " message: " + message);
        }
        if (sendFacebook) {
            String fbUsername = databaseService.getFbUsername(getUsername());
            System.out.println("Sending to Facebook as: " + fbUsername + " message: " + message);
        }
    }

    public String getUsername() {
        return username;
    }
}

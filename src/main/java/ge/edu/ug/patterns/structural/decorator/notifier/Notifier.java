package ge.edu.ug.patterns.structural.decorator.notifier;

public class Notifier implements INotifier{
    protected final DatabaseService databaseService;
    private final String username;

    public Notifier(String username) {
        this.username = username;
        this.databaseService = new DatabaseService();
    }

    public void send(String message) {
        String email = databaseService.getMailFromUsername(username);
        System.out.println("Notifying " + getUsername() + " message to " + email + " message: " + message);
    }

    public String getUsername() {
        return username;
    }
}

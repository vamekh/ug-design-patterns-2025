package ge.edu.ug.patterns.structural.decorator.notifier;

// Concrete Component: only knows how to send an e-mail
public class Notifier implements INotifier {
    private final DatabaseService databaseService;
    private final String username;

    public Notifier(String username) {
        this.username = username;
        this.databaseService = new DatabaseService();
    }

    @Override
    public void send(String message) {
        String email = databaseService.getMailFromUsername(username);
        System.out.println("Notifying " + getUsername() + " message to " + email + " message: " + message);
    }

    @Override
    public String getUsername() {
        return username;
    }
}

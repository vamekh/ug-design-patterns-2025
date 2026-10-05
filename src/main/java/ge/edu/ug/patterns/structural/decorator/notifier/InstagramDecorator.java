package ge.edu.ug.patterns.structural.decorator.notifier;

// Concrete Decorator
public class InstagramDecorator extends BaseNotifierDecorator {
    public InstagramDecorator(INotifier wrapped) {
        super(wrapped);
    }

    @Override
    public void send(String message) {
        super.send(message);
        String insta = databaseService.getInsta(getUsername());
        System.out.println("Sending to Instagram as: " + insta + " message: " + message);
    }
}

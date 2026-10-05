package ge.edu.ug.patterns.structural.decorator.notifier;

// Concrete Decorator
public class FacebookDecorator extends BaseNotifierDecorator {
    public FacebookDecorator(INotifier wrapped) {
        super(wrapped);
    }

    @Override
    public void send(String message) {
        super.send(message);
        String fbUsername = databaseService.getFbUsername(getUsername());
        System.out.println("Sending to Facebook as: " + fbUsername + " message: " + message);
    }
}

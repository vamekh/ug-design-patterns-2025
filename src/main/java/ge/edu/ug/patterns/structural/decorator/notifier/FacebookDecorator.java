package ge.edu.ug.patterns.structural.decorator.notifier;

public class FacebookDecorator extends BaseNotifierDecorator {
    public FacebookDecorator(INotifier wrapped) {
        super(wrapped);
    }

    @Override
    public void send(String msg) {
        super.send(msg);
        String fbUsername = new DatabaseService().getFbUsername(getUsername());
        System.out.println("Sending to Facebook as: " + fbUsername + " message: " + msg);
    }
}

package ge.edu.ug.patterns.structural.decorator.notifier;

public class InstaNotifier extends BaseNotifierDecorator{
    public InstaNotifier(INotifier wrapped) {
        super(wrapped);
    }

    @Override
    public void send(String msg) {
        super.send(msg);
        String insta = new DatabaseService().getInsta(getUsername());
        System.out.println("Sending to Instagram as: " + insta + " message: " + msg);
    }
}

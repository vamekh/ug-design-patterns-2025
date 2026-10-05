package ge.edu.ug.patterns.structural.decorator.notifier;

// Base Decorator: forwards to the wrapped notifier
public abstract class BaseNotifierDecorator implements INotifier {
    protected final DatabaseService databaseService;
    private final INotifier wrapped;

    public BaseNotifierDecorator(INotifier wrapped) {
        this.wrapped = wrapped;
        this.databaseService = new DatabaseService();
    }

    @Override
    public void send(String message) {
        wrapped.send(message);
    }

    @Override
    public String getUsername() {
        return wrapped.getUsername();
    }
}

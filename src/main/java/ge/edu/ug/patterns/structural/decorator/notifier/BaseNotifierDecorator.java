package ge.edu.ug.patterns.structural.decorator.notifier;

public abstract class BaseNotifierDecorator implements INotifier{
    protected final DatabaseService databaseService;
    final INotifier wrapped;

    public BaseNotifierDecorator(INotifier wrapped) {
        this.wrapped = wrapped;
        this.databaseService = new DatabaseService();
    }

    public void send(String msg){
        wrapped.send(msg);
    }

    public String getUsername(){
        return wrapped.getUsername();
    }
}

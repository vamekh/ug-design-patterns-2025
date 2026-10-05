package ge.edu.ug.patterns.behavioral.observer.restaurant;

// Concrete Observer
public class HungryPerson implements Observer {

    int receiptNumber;
    String name;
    Observable restaurant;
    private boolean served;
    private int notifications;

    public HungryPerson(int receiptNumber, String name, Observable restaurant) {
        this.receiptNumber = receiptNumber;
        this.name = name;
        this.restaurant = restaurant;
    }

    @Override
    public void notify(KitchenNotification notification) {
        notifications++;
        if (notification.receiptNumber == receiptNumber) {
            System.out.println(name + " is happy, his/her meal is ready!");
            served = true;
            restaurant.unsubscribe(this);
        } else {
            System.out.println(name + " says: Oh no, not my number yet, how long should I wait?!");
        }
    }

    public boolean isServed() {
        return served;
    }

    public int getNotifications() {
        return notifications;
    }
}

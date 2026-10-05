package ge.edu.ug.patterns.behavioral.observer.restaurant;

public class HungryPerson {

    int receiptNumber;
    String name;
    FastFoodRestaurant restaurant;
    private boolean served;
    private int checks;

    public HungryPerson(int receiptNumber, String name, FastFoodRestaurant restaurant) {
        this.receiptNumber = receiptNumber;
        this.name = name;
        this.restaurant = restaurant;
    }

    // Polling: has to be called again and again until the meal is ready
    public void checkScreen() {
        if (served) {
            return;
        }
        checks++;
        if (restaurant.isReady(receiptNumber)) {
            System.out.println(name + " is happy, his/her meal is ready!");
            served = true;
        } else {
            System.out.println(name + " says: Oh no, not my number yet, how long should I wait?!");
        }
    }

    public boolean isServed() {
        return served;
    }

    public int getChecks() {
        return checks;
    }
}

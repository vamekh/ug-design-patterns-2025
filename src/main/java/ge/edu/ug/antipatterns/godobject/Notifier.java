package ge.edu.ug.antipatterns.godobject;

import java.util.ArrayList;
import java.util.List;

// One responsibility: tell the customer what happened (here: records the e-mails it "sends").
public class Notifier {
    private final List<String> sentEmails = new ArrayList<>();

    public void orderConfirmed(Order order, double total) {
        sentEmails.add("To: " + order.getCustomerEmail()
                + " | Your order " + order.getId() + " is confirmed. Total: " + total + " GEL");
    }

    public void orderCancelled(Order order, double refund) {
        sentEmails.add("To: " + order.getCustomerEmail()
                + " | Your order " + order.getId() + " was cancelled. Refund: " + refund + " GEL");
    }

    public List<String> getSentEmails() {
        return sentEmails;
    }
}

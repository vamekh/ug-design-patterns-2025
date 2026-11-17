package ge.edu.ug.patterns.behavioral.mediator.onlinejoker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class JokerPlayer extends JokerMember{

    private final List<String> cards = new ArrayList<>();
    private final List<String> notifications = new ArrayList<>();
    private final String name;
    private final long thinkingTimeMillis;
    private final Random random = new Random();

    public JokerPlayer(String name, JokerMediator mediator) {
        this(name, mediator, 2000);
    }

    public JokerPlayer(String name, JokerMediator mediator, long thinkingTimeMillis) {
        super(mediator);
        this.name = name;
        this.thinkingTimeMillis = thinkingTimeMillis;
    }

    @Override
    public void receiveCard(List<String> cards) {
        // keep our own copy, so the dealer's list can't change our hand
        this.cards.clear();
        this.cards.addAll(cards);
    }

    @Override
    public void notify(String card) {
        notifications.add(card);
        System.out.println(name + " notified of card played: " + card);
    }

    @Override
    public void act() {
        if (cards.isEmpty()) {
            System.out.println(name + " has no cards left.");
            return;
        }
        if (thinkingTimeMillis > 0) {
            try {
                Thread.sleep(thinkingTimeMillis); // Simulate thinking time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        System.out.println(name + " is acting.");
        String card = cards.remove(random.nextInt(cards.size()));
        sendCard(card);
    }

    @Override
    public void sendCard(String card) {
        System.out.println(name + " played card: " + card);
        mediator.broadcastMessage(this, card);
    }

    @Override
    public boolean hasCards() {
        return !cards.isEmpty();
    }

    public List<String> getCards() {
        return Collections.unmodifiableList(cards);
    }

    public List<String> getNotifications() {
        return Collections.unmodifiableList(notifications);
    }

    @Override
    public String getName() {
        return name;
    }
}

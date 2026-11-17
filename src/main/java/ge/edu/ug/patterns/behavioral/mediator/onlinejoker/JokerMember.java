package ge.edu.ug.patterns.behavioral.mediator.onlinejoker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Colleague: knows only the mediator, never the other players.
// Subclasses decide which card to play in chooseCard().
public abstract class JokerMember {

    protected final JokerMediator mediator;
    private final String name;
    private final long thinkingTimeMillis;

    private final List<Card> hand = new ArrayList<>();
    private final List<Card> seenCards = new ArrayList<>();
    private final List<String> roundWinners = new ArrayList<>();
    private final List<String> messages = new ArrayList<>();

    protected JokerMember(String name, JokerMediator mediator, long thinkingTimeMillis) {
        this.name = name;
        this.mediator = mediator;
        this.thinkingTimeMillis = thinkingTimeMillis;
    }

    public void receiveHand(List<Card> cards) {
        // keep our own copy, so the dealer's list can't change our hand
        hand.clear();
        hand.addAll(cards);
        seenCards.clear();
        roundWinners.clear();
    }

    public void takeTurn() {
        if (hand.isEmpty()) {
            System.out.println(name + " has no cards left.");
            return;
        }
        think();
        playCard(chooseCard());
    }

    protected abstract Card chooseCard();

    public boolean playCard(Card card) {
        if (!hand.contains(card)) {
            throw new IllegalArgumentException(name + " does not hold " + card);
        }
        System.out.println(name + " plays " + card);
        boolean accepted = mediator.broadcastMove(this, card);
        if (accepted) {
            hand.remove(card);
        }
        return accepted;
    }

    public void onCardPlayed(String playerName, Card card) {
        seenCards.add(card);
    }

    public void onRoundWon(int roundNumber, String winnerName, Card winningCard) {
        roundWinners.add(winnerName);
        if (winnerName.equals(name)) {
            System.out.println(name + ": I won round " + roundNumber + " with " + winningCard + "!");
        }
    }

    public void onMessage(String message) {
        messages.add(message);
        System.out.println(name + " got message: " + message);
    }

    public boolean hasCards() {
        return !hand.isEmpty();
    }

    public List<Card> getHand() {
        return Collections.unmodifiableList(hand);
    }

    public List<Card> getSeenCards() {
        return Collections.unmodifiableList(seenCards);
    }

    public List<String> getRoundWinners() {
        return Collections.unmodifiableList(roundWinners);
    }

    public List<String> getMessages() {
        return Collections.unmodifiableList(messages);
    }

    public String getName() {
        return name;
    }

    private void think() {
        if (thinkingTimeMillis <= 0) {
            return;
        }
        try {
            Thread.sleep(thinkingTimeMillis); // Simulate thinking time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}

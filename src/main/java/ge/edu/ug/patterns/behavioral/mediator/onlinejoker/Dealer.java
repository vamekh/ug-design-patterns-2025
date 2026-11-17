package ge.edu.ug.patterns.behavioral.mediator.onlinejoker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

// Joker is played with a 36-card deck: 6 to A in four suits,
// with the two black sixes (6♠, 6♣) replaced by two jokers.
public class Dealer {
    public static final int DECK_SIZE = 36;
    public static final String RED_JOKER = "Red Joker";
    public static final String BLACK_JOKER = "Black Joker";

    private static final String[] SUITS = {"♠", "♣", "♥", "♦"};
    private static final String[] RANKS = {"6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    private final Random random;
    private List<String> deck = new ArrayList<>();

    public Dealer() {
        this(new Random());
    }

    public Dealer(Random random) {
        this.random = random;
    }

    public void startNewGame() {
        deck = new ArrayList<>();
        for (String suit : SUITS) {
            for (String rank : RANKS) {
                boolean blackSix = rank.equals("6") && (suit.equals("♠") || suit.equals("♣"));
                if (!blackSix) {
                    deck.add(rank + suit);
                }
            }
        }
        deck.add(RED_JOKER);
        deck.add(BLACK_JOKER);
        Collections.shuffle(deck, random);
        System.out.println("Starting a new game...");
    }

    public List<String> getRandomCardsFromTheDeck(int numberOfCards) {
        if (numberOfCards > deck.size()) {
            throw new IllegalStateException(
                    "Cannot deal " + numberOfCards + " cards, only " + deck.size() + " left in the deck");
        }
        // the deck is already shuffled, so the top cards are random
        List<String> top = deck.subList(0, numberOfCards);
        List<String> dealt = new ArrayList<>(top);
        top.clear(); // remove the dealt cards from the deck to avoid duplicates
        return dealt;
    }

    public int cardsLeft() {
        return deck.size();
    }
}

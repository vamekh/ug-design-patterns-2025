package ge.edu.ug.patterns.behavioral.mediator.onlinejoker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

// Joker is played with a 36-card deck: 6 to A in four suits,
// with the two black sixes (6♠, 6♣) replaced by two jokers.
public class Dealer {
    public static final int DECK_SIZE = 36;

    private final Random random;
    private List<Card> deck = new ArrayList<>();

    public Dealer() {
        this(new Random());
    }

    public Dealer(Random random) {
        this.random = random;
    }

    public static List<Card> fullDeck() {
        List<Card> cards = new ArrayList<>();
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                if (rank == Card.Rank.JOKER) {
                    continue;
                }
                boolean blackSix = rank == Card.Rank.SIX && (suit == Card.Suit.SPADES || suit == Card.Suit.CLUBS);
                if (!blackSix) {
                    cards.add(new Card(rank, suit));
                }
            }
        }
        cards.add(Card.RED_JOKER);
        cards.add(Card.BLACK_JOKER);
        return cards;
    }

    public void shuffleNewDeck() {
        deck = fullDeck();
        Collections.shuffle(deck, random);
        System.out.println("Starting a new game...");
    }

    public List<Card> deal(int numberOfCards) {
        if (numberOfCards > deck.size()) {
            throw new IllegalStateException(
                    "Cannot deal " + numberOfCards + " cards, only " + deck.size() + " left in the deck");
        }
        // the deck is already shuffled, so the top cards are random
        List<Card> top = deck.subList(0, numberOfCards);
        List<Card> dealt = new ArrayList<>(top);
        top.clear(); // remove the dealt cards from the deck to avoid duplicates
        return dealt;
    }

    public int cardsLeft() {
        return deck.size();
    }
}

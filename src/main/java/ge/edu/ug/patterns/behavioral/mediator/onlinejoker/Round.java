package ge.edu.ug.patterns.behavioral.mediator.onlinejoker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// One round: every player plays one card, the strongest card takes the round.
// Rules (simplified Joker, no trumps):
//  - a joker beats everything; when both jokers are played, the later one wins
//  - otherwise the highest card of the suit that was led wins
public class Round {

    public record Move(JokerMember player, Card card) {
    }

    private final List<Move> moves = new ArrayList<>();

    public void add(JokerMember player, Card card) {
        moves.add(new Move(player, card));
    }

    public int size() {
        return moves.size();
    }

    public List<Card> cards() {
        List<Card> cards = new ArrayList<>();
        for (Move move : moves) {
            cards.add(move.card());
        }
        return Collections.unmodifiableList(cards);
    }

    public Move winningMove() {
        if (moves.isEmpty()) {
            throw new IllegalStateException("No cards were played in this round");
        }
        List<Card> cards = cards();
        return moves.get(cards.indexOf(winningCard(cards)));
    }

    // The suit everyone follows: the first card that is not a joker
    public static Card.Suit ledSuit(List<Card> cards) {
        for (Card card : cards) {
            if (!card.isJoker()) {
                return card.suit();
            }
        }
        return null;
    }

    public static Card winningCard(List<Card> cards) {
        Card.Suit led = ledSuit(cards);
        Card best = cards.get(0);
        for (Card card : cards.subList(1, cards.size())) {
            if (beats(card, best, led)) {
                best = card;
            }
        }
        return best;
    }

    // Does the challenger, played after best, take the round from it?
    public static boolean beats(Card challenger, Card best, Card.Suit ledSuit) {
        if (challenger.isJoker()) {
            return true;
        }
        if (best.isJoker()) {
            return false;
        }
        if (challenger.suit() != ledSuit) {
            return false;
        }
        return best.suit() != ledSuit || challenger.rank().ordinal() > best.rank().ordinal();
    }
}

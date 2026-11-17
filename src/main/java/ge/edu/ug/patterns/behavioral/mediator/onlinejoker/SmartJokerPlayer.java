package ge.edu.ug.patterns.behavioral.mediator.onlinejoker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

// Remembers every card played in the game and uses that memory to choose:
//  - leading a round: plays a card no unplayed card of its suit can beat
//  - following: wins with the cheapest card that can win, otherwise throws away its weakest card
public class SmartJokerPlayer extends JokerMember {

    // weakest first; jokers are the most valuable, so they come last
    private static final Comparator<Card> BY_STRENGTH = Comparator.comparingInt(card -> card.rank().ordinal());

    private final Set<Card> rememberedCards = new HashSet<>();
    private final List<Card> currentRound = new ArrayList<>();

    public SmartJokerPlayer(String name, JokerMediator mediator) {
        this(name, mediator, 2000);
    }

    public SmartJokerPlayer(String name, JokerMediator mediator, long thinkingTimeMillis) {
        super(name, mediator, thinkingTimeMillis);
    }

    @Override
    public void receiveHand(List<Card> cards) {
        super.receiveHand(cards);
        rememberedCards.clear();
        currentRound.clear();
    }

    @Override
    public boolean playCard(Card card) {
        // remember our own card before the mediator can finish the round
        rememberedCards.add(card);
        currentRound.add(card);
        boolean accepted = super.playCard(card);
        if (!accepted) {
            rememberedCards.remove(card);
            currentRound.remove(card);
        }
        return accepted;
    }

    @Override
    public void onCardPlayed(String playerName, Card card) {
        super.onCardPlayed(playerName, card);
        rememberedCards.add(card);
        currentRound.add(card);
    }

    @Override
    public void onRoundWon(int roundNumber, String winnerName, Card winningCard) {
        super.onRoundWon(roundNumber, winnerName, winningCard);
        currentRound.clear();
    }

    public Set<Card> getRememberedCards() {
        return Collections.unmodifiableSet(rememberedCards);
    }

    @Override
    protected Card chooseCard() {
        List<Card> hand = new ArrayList<>(getHand());
        hand.sort(BY_STRENGTH);
        if (currentRound.isEmpty()) {
            return chooseLeadCard(hand);
        }

        Card best = Round.winningCard(currentRound);
        Card.Suit led = Round.ledSuit(currentRound);
        List<Card> winners = new ArrayList<>();
        for (Card card : hand) {
            if (Round.beats(card, best, led)) {
                winners.add(card);
            }
        }
        if (winners.isEmpty()) {
            return weakest(hand);
        }
        boolean lastToPlay = currentRound.size() == OnlineJokerMediator.PLAYERS - 1;
        if (lastToPlay) {
            return winners.get(0); // nobody plays after us, the cheapest winner is enough
        }
        // others still play after us: prefer a winner none of the unplayed cards can beat
        return winners.stream().filter(this::cannotBeBeaten).findFirst().orElse(winners.get(0));
    }

    private Card chooseLeadCard(List<Card> hand) {
        Optional<Card> safe = hand.stream().filter(card -> !card.isJoker() && cannotBeBeaten(card)).findFirst();
        if (safe.isPresent()) {
            return safe.get();
        }
        Optional<Card> safeJoker = hand.stream().filter(card -> card.isJoker() && cannotBeBeaten(card)).findFirst();
        return safeJoker.orElseGet(() -> weakest(hand));
    }

    // The weakest card that is not a joker; jokers are kept for later
    private Card weakest(List<Card> sortedHand) {
        return sortedHand.stream().filter(card -> !card.isJoker()).findFirst().orElse(sortedHand.get(0));
    }

    // True when every higher card of the same suit has been played or is in our hand.
    // An unplayed joker could still beat any card; counting jokers would make no card safe
    // until both are out, so for ordinary cards we take that risk. A joker is safe once
    // the other joker is gone.
    boolean cannotBeBeaten(Card card) {
        for (Card other : Dealer.fullDeck()) {
            boolean couldBeat = card.isJoker()
                    ? other.isJoker() && !other.equals(card)
                    : !other.isJoker() && other.suit() == card.suit() && other.rank().ordinal() > card.rank().ordinal();
            if (couldBeat && !rememberedCards.contains(other) && !getHand().contains(other)) {
                return false;
            }
        }
        return true;
    }
}

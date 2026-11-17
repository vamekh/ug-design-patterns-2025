package ge.edu.ug.patterns.behavioral.mediator.onlinejoker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OnlineJokerMediator implements JokerMediator{
    public static final int PLAYERS = 4;
    public static final int CARDS_PER_PLAYER = Dealer.DECK_SIZE / PLAYERS; // 9

    private final List<JokerMember> members = new ArrayList<>();
    private final List<String> playedCards = new ArrayList<>();
    private final Dealer dealer;
    private int currentPlayerIndex = 0;
    private boolean gameRunning = false;

    public OnlineJokerMediator() {
        this(new Dealer());
    }

    public OnlineJokerMediator(Dealer dealer) {
        this.dealer = dealer;
    }

    @Override
    public void broadcastMessage(JokerMember sender, String card) {
        if (!gameRunning) {
            System.out.println("No game is running, " + sender.getName() + "'s card is ignored.");
            return;
        }
        if (sender != members.get(currentPlayerIndex)) {
            System.out.println("It's not " + sender.getName() + "'s turn.");
            return;
        }
        playedCards.add(card);
        for (JokerMember member : members) {
            if (member != sender) {
                member.notify(card);
            }
        }
        currentPlayerIndex = (currentPlayerIndex + 1) % members.size();
    }

    @Override
    public void addMember(JokerMember jokerMember) {
        if (members.contains(jokerMember)) {
            return;
        }
        if (members.size() >= PLAYERS) {
            System.out.println("Cannot add more than " + PLAYERS + " members to the game.");
            return;
        }
        members.add(jokerMember);
        if (members.size() == PLAYERS) {
            System.out.println("The table is full, the game can start with " + PLAYERS + " members.");
        }
    }

    @Override
    public void startNewGame() {
        if (members.size() != PLAYERS) {
            System.out.println("Joker needs " + PLAYERS + " players, only " + members.size() + " joined.");
            return;
        }
        dealer.startNewGame();
        playedCards.clear();
        currentPlayerIndex = 0;
        for (JokerMember member : members) {
            member.receiveCard(dealer.getRandomCardsFromTheDeck(CARDS_PER_PLAYER));
        }
        gameRunning = true;

        // Players take turns until the cards run out or someone stops the game.
        // A loop instead of act() -> broadcastMessage() -> act() recursion.
        while (gameRunning) {
            JokerMember current = members.get(currentPlayerIndex);
            if (!current.hasCards()) {
                stopGame("no more cards");
                break;
            }
            int playedBefore = playedCards.size();
            current.act();
            if (gameRunning && playedCards.size() == playedBefore) {
                stopGame(current.getName() + " did not play a card");
            }
        }
    }

    @Override
    public void stopGame(String reason) {
        if (!gameRunning) {
            return;
        }
        gameRunning = false;
        System.out.println("Game over: " + reason + ". Cards played: " + playedCards.size());
    }

    @Override
    public boolean isGameRunning() {
        return gameRunning;
    }

    @Override
    public void removeMember(JokerMember jokerMember) {
        if (!members.remove(jokerMember)) {
            return;
        }
        members.forEach(member -> member.notify(jokerMember.getName() + " has left the game."));
        if (gameRunning) {
            stopGame(jokerMember.getName() + " left the game");
        }
    }

    public List<String> getPlayedCards() {
        return Collections.unmodifiableList(playedCards);
    }

    public List<JokerMember> getMembers() {
        return Collections.unmodifiableList(members);
    }
}

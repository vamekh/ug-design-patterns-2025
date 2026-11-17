package ge.edu.ug.patterns.behavioral.mediator.onlinejoker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OnlineJokerMediator implements JokerMediator{
    public static final int PLAYERS = 4;
    public static final int CARDS_PER_PLAYER = Dealer.DECK_SIZE / PLAYERS; // 9

    private final List<JokerMember> members = new ArrayList<>();
    private final List<Card> playedCards = new ArrayList<>();
    private final Map<JokerMember, Integer> roundsWon = new LinkedHashMap<>();
    private final Dealer dealer;
    private Round currentRound = new Round();
    private int roundNumber = 1;
    private int currentPlayerIndex = 0;
    private boolean gameRunning = false;

    public OnlineJokerMediator() {
        this(new Dealer());
    }

    public OnlineJokerMediator(Dealer dealer) {
        this.dealer = dealer;
    }

    @Override
    public boolean broadcastMove(JokerMember sender, Card card) {
        if (!gameRunning) {
            System.out.println("No game is running, " + sender.getName() + "'s card is ignored.");
            return false;
        }
        if (sender != members.get(currentPlayerIndex)) {
            System.out.println("It's not " + sender.getName() + "'s turn.");
            return false;
        }
        playedCards.add(card);
        currentRound.add(sender, card);
        for (JokerMember member : members) {
            if (member != sender) {
                member.onCardPlayed(sender.getName(), card);
            }
        }
        if (currentRound.size() == members.size()) {
            finishRound();
        } else {
            currentPlayerIndex = (currentPlayerIndex + 1) % members.size();
        }
        return true;
    }

    // Tells everyone who took the round; the winner leads the next one
    private void finishRound() {
        Round.Move winningMove = currentRound.winningMove();
        JokerMember winner = winningMove.player();
        roundsWon.merge(winner, 1, Integer::sum);
        System.out.println("Round " + roundNumber + " " + currentRound.cards()
                + " is won by " + winner.getName() + " with " + winningMove.card());
        for (JokerMember member : members) {
            member.onRoundWon(roundNumber, winner.getName(), winningMove.card());
        }
        currentPlayerIndex = members.indexOf(winner);
        currentRound = new Round();
        roundNumber++;
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
        dealer.shuffleNewDeck();
        playedCards.clear();
        roundsWon.clear();
        currentRound = new Round();
        roundNumber = 1;
        currentPlayerIndex = 0;
        for (JokerMember member : members) {
            roundsWon.put(member, 0);
            member.receiveHand(dealer.deal(CARDS_PER_PLAYER));
        }
        gameRunning = true;

        // Players take turns until the cards run out or someone stops the game.
        // A loop instead of takeTurn() -> broadcastMove() -> takeTurn() recursion.
        while (gameRunning) {
            JokerMember current = members.get(currentPlayerIndex);
            if (!current.hasCards()) {
                stopGame("no more cards");
                announceGameWinner();
                break;
            }
            int playedBefore = playedCards.size();
            current.takeTurn();
            if (gameRunning && playedCards.size() == playedBefore) {
                stopGame(current.getName() + " did not play a card");
            }
        }
    }

    private void announceGameWinner() {
        List<String> winners = getGameWinners();
        String message = "Game winner: " + String.join(", ", winners)
                + " with " + Collections.max(roundsWon.values()) + " rounds";
        System.out.println(message + ". Rounds won: " + roundsWonByName());
        members.forEach(member -> member.onMessage(message));
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
        members.forEach(member -> member.onMessage(jokerMember.getName() + " has left the game."));
        if (gameRunning) {
            stopGame(jokerMember.getName() + " left the game");
        }
    }

    // Players with the most rounds won; more than one on a tie
    public List<String> getGameWinners() {
        if (roundsWon.isEmpty()) {
            return List.of();
        }
        int most = Collections.max(roundsWon.values());
        List<String> winners = new ArrayList<>();
        roundsWon.forEach((member, rounds) -> {
            if (rounds == most) {
                winners.add(member.getName());
            }
        });
        return winners;
    }

    public int getRoundsWon(JokerMember member) {
        return roundsWon.getOrDefault(member, 0);
    }

    private Map<String, Integer> roundsWonByName() {
        Map<String, Integer> byName = new LinkedHashMap<>();
        roundsWon.forEach((member, rounds) -> byName.put(member.getName(), rounds));
        return byName;
    }

    public List<Card> getPlayedCards() {
        return Collections.unmodifiableList(playedCards);
    }

    public List<JokerMember> getMembers() {
        return Collections.unmodifiableList(members);
    }
}

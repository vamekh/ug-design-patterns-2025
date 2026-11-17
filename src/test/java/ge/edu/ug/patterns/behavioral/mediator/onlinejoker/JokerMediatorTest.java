package ge.edu.ug.patterns.behavioral.mediator.onlinejoker;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JokerMediatorTest {

    private static List<Card> cards(String... texts) {
        return java.util.Arrays.stream(texts).map(Card::of).toList();
    }

    @Test
    public void testMediator() {
        OnlineJokerMediator mediator = new OnlineJokerMediator();

        JokerMember member1 = new RandomJokerPlayer("Alice", mediator, 0);
        JokerMember member2 = new RandomJokerPlayer("Bob", mediator, 0);
        JokerMember member3 = new RandomJokerPlayer("Charlie", mediator, 0);
        JokerMember member4 = new SmartJokerPlayer("David", mediator, 0);

        mediator.addMember(member1);
        mediator.addMember(member2);
        mediator.addMember(member3);
        mediator.addMember(member4);

        mediator.startNewGame();

        // all 36 cards were played exactly once, then the game stopped by itself
        assertFalse(mediator.isGameRunning());
        assertEquals(Dealer.DECK_SIZE, mediator.getPlayedCards().size());
        assertEquals(Dealer.DECK_SIZE, new HashSet<>(mediator.getPlayedCards()).size());

        int totalRoundsWon = 0;
        for (JokerMember player : List.of(member1, member2, member3, member4)) {
            assertFalse(player.hasCards());
            // each player sees the 27 cards the other three played
            assertEquals(27, player.getSeenCards().size());
            // and is told the winner of all 9 rounds
            assertEquals(9, player.getRoundWinners().size());
            totalRoundsWon += mediator.getRoundsWon(player);
        }
        assertEquals(9, totalRoundsWon);
        assertFalse(mediator.getGameWinners().isEmpty());
        assertTrue(member1.getMessages().get(0).startsWith("Game winner: "));
    }

    @Test
    public void deckHasTheRealJokerCards() {
        Dealer dealer = new Dealer();
        dealer.shuffleNewDeck();

        List<Card> deck = dealer.deal(Dealer.DECK_SIZE);
        Set<Card> unique = new HashSet<>(deck);

        assertEquals(36, unique.size());
        assertTrue(unique.containsAll(List.of(Card.RED_JOKER, Card.BLACK_JOKER)));
        assertTrue(unique.containsAll(cards("6♥", "6♦", "A♠", "10♣")));
        assertFalse(unique.contains(new Card(Card.Rank.SIX, Card.Suit.SPADES)));
        assertFalse(unique.contains(new Card(Card.Rank.SIX, Card.Suit.CLUBS)));
        assertEquals(0, dealer.cardsLeft());
        assertThrows(IllegalStateException.class, () -> dealer.deal(1));
    }

    @Test
    public void highestCardOfTheLedSuitWinsTheRound() {
        // K♣ is higher, but clubs were not led
        assertEquals(Card.of("10♥"), Round.winningCard(cards("7♥", "K♣", "10♥", "9♥")));
        assertEquals(Card.of("A♦"), Round.winningCard(cards("A♦", "K♦", "Q♠", "6♦")));
    }

    @Test
    public void jokerWinsTheRoundAndTheLaterJokerBeatsTheEarlierOne() {
        assertEquals(Card.BLACK_JOKER, Round.winningCard(List.of(Card.of("A♥"), Card.BLACK_JOKER, Card.of("K♥"), Card.of("6♥"))));
        assertEquals(Card.RED_JOKER, Round.winningCard(List.of(Card.BLACK_JOKER, Card.of("A♠"), Card.RED_JOKER, Card.of("7♠"))));
    }

    @Test
    public void everyoneIsToldTheRoundWinnerAndTheWinnerLeadsNext() {
        OnlineJokerMediator mediator = new OnlineJokerMediator();
        List<JokerMember> players = List.of(
                new RandomJokerPlayer("Alice", mediator, 0),
                new RandomJokerPlayer("Bob", mediator, 0),
                new RandomJokerPlayer("Charlie", mediator, 0),
                new RandomJokerPlayer("David", mediator, 0));
        players.forEach(mediator::addMember);
        mediator.startNewGame();

        List<String> winners = players.get(0).getRoundWinners();
        for (JokerMember player : players) {
            assertEquals(winners, player.getRoundWinners());
        }
        // the winner of round 1 played the first card of round 2
        String round1Winner = winners.get(0);
        JokerMember leader = players.stream().filter(p -> p.getName().equals(round1Winner)).findFirst().orElseThrow();
        Card firstCardOfRound2 = mediator.getPlayedCards().get(4);
        for (JokerMember other : players) {
            if (other != leader) {
                assertTrue(other.getSeenCards().contains(firstCardOfRound2));
            }
        }
        assertFalse(leader.getSeenCards().contains(firstCardOfRound2));
    }

    @Test
    public void eachPlayerIsDealtNineCards() {
        OnlineJokerMediator mediator = new OnlineJokerMediator();
        // Alice stops the game on her first turn, before playing, so the hands stay full
        JokerMember alice = new RandomJokerPlayer("Alice", mediator, 0) {
            @Override
            public void takeTurn() {
                mediator.stopGame("Alice stopped the game");
            }
        };
        JokerMember bob = new SmartJokerPlayer("Bob", mediator, 0);
        mediator.addMember(alice);
        mediator.addMember(bob);
        mediator.addMember(new RandomJokerPlayer("Charlie", mediator, 0));
        mediator.addMember(new RandomJokerPlayer("David", mediator, 0));

        mediator.startNewGame();

        assertEquals(9, alice.getHand().size());
        assertEquals(9, bob.getHand().size());
        assertFalse(mediator.isGameRunning());
        assertTrue(mediator.getPlayedCards().isEmpty());
    }

    @Test
    public void gameCanBeStoppedMidway() {
        OnlineJokerMediator mediator = new OnlineJokerMediator();
        JokerMember alice = new RandomJokerPlayer("Alice", mediator, 0);
        // Bob plays one card and then stops the game
        JokerMember bob = new RandomJokerPlayer("Bob", mediator, 0) {
            @Override
            public void takeTurn() {
                super.takeTurn();
                mediator.stopGame("Bob stopped the game");
            }
        };
        mediator.addMember(alice);
        mediator.addMember(bob);
        mediator.addMember(new RandomJokerPlayer("Charlie", mediator, 0));
        mediator.addMember(new RandomJokerPlayer("David", mediator, 0));

        mediator.startNewGame();

        assertFalse(mediator.isGameRunning());
        assertEquals(2, mediator.getPlayedCards().size());
        assertEquals(8, alice.getHand().size());
        assertEquals(8, bob.getHand().size());

        // after the game stopped, a card is refused and stays in the hand
        assertFalse(alice.playCard(alice.getHand().get(0)));
        assertEquals(2, mediator.getPlayedCards().size());
        assertEquals(8, alice.getHand().size());
    }

    @Test
    public void playerLeavingStopsTheGame() {
        OnlineJokerMediator mediator = new OnlineJokerMediator();
        JokerMember alice = new RandomJokerPlayer("Alice", mediator, 0);
        JokerMember bob = new RandomJokerPlayer("Bob", mediator, 0) {
            @Override
            public void takeTurn() {
                mediator.removeMember(this);
            }
        };
        mediator.addMember(alice);
        mediator.addMember(bob);
        mediator.addMember(new RandomJokerPlayer("Charlie", mediator, 0));
        mediator.addMember(new RandomJokerPlayer("David", mediator, 0));

        mediator.startNewGame();

        assertFalse(mediator.isGameRunning());
        assertEquals(1, mediator.getPlayedCards().size());
        assertEquals(3, mediator.getMembers().size());
        assertTrue(alice.getMessages().contains("Bob has left the game."));
    }

    @Test
    public void gameNeedsExactlyFourPlayers() {
        OnlineJokerMediator mediator = new OnlineJokerMediator();
        JokerMember alice = new RandomJokerPlayer("Alice", mediator, 0);
        mediator.addMember(alice);
        mediator.addMember(new RandomJokerPlayer("Bob", mediator, 0));
        mediator.addMember(new RandomJokerPlayer("Charlie", mediator, 0));

        mediator.startNewGame();

        assertFalse(mediator.isGameRunning());
        assertFalse(alice.hasCards());

        mediator.addMember(new RandomJokerPlayer("David", mediator, 0));
        mediator.addMember(new RandomJokerPlayer("Eve", mediator, 0));
        assertEquals(4, mediator.getMembers().size());
    }

    @Test
    public void playingOutOfTurnIsRefused() {
        OnlineJokerMediator mediator = new OnlineJokerMediator();
        JokerMember bob = new RandomJokerPlayer("Bob", mediator, 0);
        // Alice tries to make Bob play out of turn, then stops the game
        JokerMember alice = new RandomJokerPlayer("Alice", mediator, 0) {
            @Override
            public void takeTurn() {
                assertFalse(bob.playCard(bob.getHand().get(0)));
                mediator.stopGame("test over");
            }
        };
        mediator.addMember(alice);
        mediator.addMember(bob);
        mediator.addMember(new RandomJokerPlayer("Charlie", mediator, 0));
        mediator.addMember(new RandomJokerPlayer("David", mediator, 0));

        mediator.startNewGame();

        assertTrue(mediator.getPlayedCards().isEmpty());
        assertEquals(9, bob.getHand().size());
    }

    @Test
    public void playingACardYouDoNotHoldIsRejected() {
        OnlineJokerMediator mediator = new OnlineJokerMediator();
        JokerMember alice = new RandomJokerPlayer("Alice", mediator, 0);
        alice.receiveHand(cards("7♥"));
        assertThrows(IllegalArgumentException.class, () -> alice.playCard(Card.of("A♥")));
    }

    // --- SmartJokerPlayer ---

    @Test
    public void smartPlayerRemembersEveryPlayedCard() {
        OnlineJokerMediator mediator = new OnlineJokerMediator();
        SmartJokerPlayer smart = new SmartJokerPlayer("Smart", mediator, 0);
        mediator.addMember(new RandomJokerPlayer("Alice", mediator, 0));
        mediator.addMember(new RandomJokerPlayer("Bob", mediator, 0));
        mediator.addMember(new RandomJokerPlayer("Charlie", mediator, 0));
        mediator.addMember(smart);

        mediator.startNewGame();

        assertEquals(new HashSet<>(mediator.getPlayedCards()), smart.getRememberedCards());
    }

    @Test
    public void smartPlayerLeadsACardNobodyCanBeat() {
        SmartJokerPlayer smart = new SmartJokerPlayer("Smart", new OnlineJokerMediator(), 0);
        smart.receiveHand(cards("7♣", "K♥", "8♦"));
        // A♥ was played in an earlier round, so K♥ is now the highest heart left
        smart.onCardPlayed("Alice", Card.of("A♥"));
        smart.onCardPlayed("Bob", Card.of("6♥"));
        smart.onCardPlayed("Charlie", Card.of("9♥"));
        smart.onRoundWon(1, "Alice", Card.of("A♥"));

        assertEquals(Card.of("K♥"), smart.chooseCard());
    }

    @Test
    public void smartPlayerWithoutAMemoryOfTheAceLeadsItsWeakestCard() {
        SmartJokerPlayer smart = new SmartJokerPlayer("Smart", new OnlineJokerMediator(), 0);
        smart.receiveHand(cards("7♣", "K♥", "8♦"));

        // A♥, A♣ and A♦ are still out, so no card is safe: throw away the weakest
        assertEquals(Card.of("7♣"), smart.chooseCard());
    }

    @Test
    public void smartPlayerWinsCheaplyWhenLastToPlay() {
        SmartJokerPlayer smart = new SmartJokerPlayer("Smart", new OnlineJokerMediator(), 0);
        smart.receiveHand(List.of(Card.of("A♠"), Card.of("10♠"), Card.of("7♦"), Card.RED_JOKER));
        smart.onCardPlayed("Alice", Card.of("8♠"));
        smart.onCardPlayed("Bob", Card.of("9♠"));
        smart.onCardPlayed("Charlie", Card.of("6♦"));

        // 10♠ is enough to beat 9♠; A♠ and the joker are saved
        assertEquals(Card.of("10♠"), smart.chooseCard());
    }

    @Test
    public void smartPlayerThrowsItsWeakestCardWhenItCannotWin() {
        SmartJokerPlayer smart = new SmartJokerPlayer("Smart", new OnlineJokerMediator(), 0);
        smart.receiveHand(cards("8♥", "Q♦", "6♦"));
        smart.onCardPlayed("Alice", Card.of("A♠"));

        assertEquals(Card.of("6♦"), smart.chooseCard());
    }

    @Test
    public void smartPlayerWinsMoreRoundsThanRandomPlayers() {
        int smartRounds = 0;
        int randomRounds = 0;
        int games = 200;
        for (int game = 0; game < games; game++) {
            OnlineJokerMediator mediator = new OnlineJokerMediator(new Dealer(new Random(game)));
            SmartJokerPlayer smart = new SmartJokerPlayer("Smart", mediator, 0);
            List<JokerMember> randoms = List.of(
                    new RandomJokerPlayer("R1", mediator, 0, new Random(game + 1000)),
                    new RandomJokerPlayer("R2", mediator, 0, new Random(game + 2000)),
                    new RandomJokerPlayer("R3", mediator, 0, new Random(game + 3000)));
            // rotate the seat so the smart player doesn't always lead the first round
            for (int seat = 0; seat < OnlineJokerMediator.PLAYERS; seat++) {
                if (seat == game % OnlineJokerMediator.PLAYERS) {
                    mediator.addMember(smart);
                } else {
                    mediator.addMember(randoms.get(seat < game % OnlineJokerMediator.PLAYERS ? seat : seat - 1));
                }
            }
            mediator.startNewGame();
            smartRounds += mediator.getRoundsWon(smart);
            for (JokerMember random : randoms) {
                randomRounds += mediator.getRoundsWon(random);
            }
        }
        double smartAverage = (double) smartRounds / games;
        double randomAverage = (double) randomRounds / (3 * games);
        System.out.printf("Rounds won per game: smart %.2f, random %.2f%n", smartAverage, randomAverage);
        assertTrue(smartAverage > randomAverage);
    }
}

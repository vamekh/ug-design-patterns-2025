package ge.edu.ug.patterns.behavioral.mediator.onlinejoker;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JokerMediatorTest {

    @Test
    public void testMediator() {
        OnlineJokerMediator mediator = new OnlineJokerMediator();

        JokerPlayer member1 = new JokerPlayer("Alice", mediator, 0);
        JokerPlayer member2 = new JokerPlayer("Bob", mediator, 0);
        JokerPlayer member3 = new JokerPlayer("Charlie", mediator, 0);
        JokerPlayer member4 = new JokerPlayer("David", mediator, 0);

        mediator.addMember(member1);
        mediator.addMember(member2);
        mediator.addMember(member3);
        mediator.addMember(member4);

        mediator.startNewGame();

        // all 36 cards were played exactly once, then the game stopped by itself
        assertFalse(mediator.isGameRunning());
        assertEquals(Dealer.DECK_SIZE, mediator.getPlayedCards().size());
        assertEquals(Dealer.DECK_SIZE, new HashSet<>(mediator.getPlayedCards()).size());
        for (JokerPlayer player : List.of(member1, member2, member3, member4)) {
            assertFalse(player.hasCards());
            // each player sees the 27 cards the other three played
            assertEquals(27, player.getNotifications().size());
        }
    }

    @Test
    public void deckHasTheRealJokerCards() {
        Dealer dealer = new Dealer();
        dealer.startNewGame();

        List<String> deck = dealer.getRandomCardsFromTheDeck(Dealer.DECK_SIZE);
        Set<String> unique = new HashSet<>(deck);

        assertEquals(36, unique.size());
        assertTrue(unique.containsAll(List.of(Dealer.RED_JOKER, Dealer.BLACK_JOKER, "6♥", "6♦", "A♠", "10♣")));
        assertFalse(unique.contains("6♠"));
        assertFalse(unique.contains("6♣"));
        assertEquals(0, dealer.cardsLeft());
        assertThrows(IllegalStateException.class, () -> dealer.getRandomCardsFromTheDeck(1));
    }

    @Test
    public void eachPlayerIsDealtNineCards() {
        OnlineJokerMediator mediator = new OnlineJokerMediator();
        // Alice stops the game on her first turn, before playing, so the hands stay full
        JokerPlayer alice = new JokerPlayer("Alice", mediator, 0) {
            @Override
            public void act() {
                mediator.stopGame("Alice stopped the game");
            }
        };
        JokerPlayer bob = new JokerPlayer("Bob", mediator, 0);
        mediator.addMember(alice);
        mediator.addMember(bob);
        mediator.addMember(new JokerPlayer("Charlie", mediator, 0));
        mediator.addMember(new JokerPlayer("David", mediator, 0));

        mediator.startNewGame();

        assertEquals(9, alice.getCards().size());
        assertEquals(9, bob.getCards().size());
        assertFalse(mediator.isGameRunning());
        assertTrue(mediator.getPlayedCards().isEmpty());
    }

    @Test
    public void gameCanBeStoppedMidway() {
        OnlineJokerMediator mediator = new OnlineJokerMediator();
        JokerPlayer alice = new JokerPlayer("Alice", mediator, 0);
        // Bob plays one card and then stops the game
        JokerPlayer bob = new JokerPlayer("Bob", mediator, 0) {
            @Override
            public void act() {
                super.act();
                mediator.stopGame("Bob stopped the game");
            }
        };
        mediator.addMember(alice);
        mediator.addMember(bob);
        mediator.addMember(new JokerPlayer("Charlie", mediator, 0));
        mediator.addMember(new JokerPlayer("David", mediator, 0));

        mediator.startNewGame();

        assertFalse(mediator.isGameRunning());
        assertEquals(2, mediator.getPlayedCards().size());
        assertEquals(8, alice.getCards().size());
        assertEquals(8, bob.getCards().size());

        // after the game stopped, playing a card is ignored
        alice.sendCard("A♥");
        assertEquals(2, mediator.getPlayedCards().size());
    }

    @Test
    public void playerLeavingStopsTheGame() {
        OnlineJokerMediator mediator = new OnlineJokerMediator();
        JokerPlayer alice = new JokerPlayer("Alice", mediator, 0);
        JokerPlayer bob = new JokerPlayer("Bob", mediator, 0) {
            @Override
            public void act() {
                mediator.removeMember(this);
            }
        };
        mediator.addMember(alice);
        mediator.addMember(bob);
        mediator.addMember(new JokerPlayer("Charlie", mediator, 0));
        mediator.addMember(new JokerPlayer("David", mediator, 0));

        mediator.startNewGame();

        assertFalse(mediator.isGameRunning());
        assertEquals(1, mediator.getPlayedCards().size());
        assertEquals(3, mediator.getMembers().size());
        assertTrue(alice.getNotifications().contains("Bob has left the game."));
    }

    @Test
    public void gameNeedsExactlyFourPlayers() {
        OnlineJokerMediator mediator = new OnlineJokerMediator();
        JokerPlayer alice = new JokerPlayer("Alice", mediator, 0);
        mediator.addMember(alice);
        mediator.addMember(new JokerPlayer("Bob", mediator, 0));
        mediator.addMember(new JokerPlayer("Charlie", mediator, 0));

        mediator.startNewGame();

        assertFalse(mediator.isGameRunning());
        assertFalse(alice.hasCards());

        mediator.addMember(new JokerPlayer("David", mediator, 0));
        mediator.addMember(new JokerPlayer("Eve", mediator, 0));
        assertEquals(4, mediator.getMembers().size());
    }

    @Test
    public void playingOutOfTurnIsIgnored() {
        OnlineJokerMediator mediator = new OnlineJokerMediator();
        JokerPlayer bob = new JokerPlayer("Bob", mediator, 0);
        // Alice tries to make Bob play out of turn, then stops the game
        JokerPlayer alice = new JokerPlayer("Alice", mediator, 0) {
            @Override
            public void act() {
                bob.sendCard("K♥");
                mediator.stopGame("test over");
            }
        };
        mediator.addMember(alice);
        mediator.addMember(bob);
        mediator.addMember(new JokerPlayer("Charlie", mediator, 0));
        mediator.addMember(new JokerPlayer("David", mediator, 0));

        mediator.startNewGame();

        assertTrue(mediator.getPlayedCards().isEmpty());
    }
}

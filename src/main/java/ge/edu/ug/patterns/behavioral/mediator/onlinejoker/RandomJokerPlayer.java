package ge.edu.ug.patterns.behavioral.mediator.onlinejoker;

import java.util.List;
import java.util.Random;

// Plays a random card from its hand and remembers nothing
public class RandomJokerPlayer extends JokerMember {

    private final Random random;

    public RandomJokerPlayer(String name, JokerMediator mediator) {
        this(name, mediator, 2000);
    }

    public RandomJokerPlayer(String name, JokerMediator mediator, long thinkingTimeMillis) {
        this(name, mediator, thinkingTimeMillis, new Random());
    }

    public RandomJokerPlayer(String name, JokerMediator mediator, long thinkingTimeMillis, Random random) {
        super(name, mediator, thinkingTimeMillis);
        this.random = random;
    }

    @Override
    protected Card chooseCard() {
        List<Card> hand = getHand();
        return hand.get(random.nextInt(hand.size()));
    }
}

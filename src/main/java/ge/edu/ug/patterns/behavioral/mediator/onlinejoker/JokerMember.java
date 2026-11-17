package ge.edu.ug.patterns.behavioral.mediator.onlinejoker;

import java.util.List;

public abstract class JokerMember {

    protected final JokerMediator mediator;

    protected JokerMember(JokerMediator mediator){
        this.mediator = mediator;
    }

    abstract void receiveCard(List<String> cards);

    abstract void notify(String card);

    abstract void act();

    abstract void sendCard(String card);

    abstract boolean hasCards();

    abstract String getName();
}

package ge.edu.ug.patterns.behavioral.mediator.chat;

import java.util.ArrayList;
import java.util.List;

// Concrete Colleague: knows only the mediator, never the other members.
public class ConcreteMember implements ChatMember {
    private final String name;
    private final ChatMediator chatMediator;
    private final List<String> receivedMessages = new ArrayList<>();

    public ConcreteMember(String name, ChatMediator chatMediator) {
        this.name = name;
        this.chatMediator = chatMediator;
        this.chatMediator.addMember(this);
    }

    @Override
    public void receiveMessage(String message) {
        receivedMessages.add(message);
    }

    @Override
    public void sendMessage(String message) {
        chatMediator.broadcastMessage(this, message);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<String> getReceivedMessages() {
        return List.copyOf(receivedMessages);
    }
}

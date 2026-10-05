package ge.edu.ug.patterns.behavioral.mediator.chat;

import java.util.ArrayList;
import java.util.List;

// PROBLEM: every member keeps references to all the other members and delivers messages itself.
// n members = n*(n-1) links; joining or leaving means updating every other member by hand,
// and forgetting one of them silently loses messages.
public class ConcreteMember implements ChatMember {
    private final String name;
    private final List<ChatMember> contacts = new ArrayList<>();
    private final List<String> receivedMessages = new ArrayList<>();

    public ConcreteMember(String name) {
        this.name = name;
    }

    public void addContact(ChatMember member) {
        contacts.add(member);
    }

    public void removeContact(ChatMember member) {
        contacts.remove(member);
    }

    @Override
    public void receiveMessage(String message) {
        receivedMessages.add(message);
    }

    @Override
    public void sendMessage(String message) {
        for (ChatMember contact : contacts) {
            contact.receiveMessage(name + ": " + message);
        }
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

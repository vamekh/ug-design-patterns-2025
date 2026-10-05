package ge.edu.ug.patterns.behavioral.mediator.chat;

import java.util.ArrayList;
import java.util.List;

// Concrete Mediator: the only object that knows all members.
public class Chat implements ChatMediator {
    private final List<ChatMember> members = new ArrayList<>();

    @Override
    public void addMember(ChatMember chatMember) {
        members.add(chatMember);
    }

    @Override
    public void removeMember(ChatMember chatMember) {
        members.remove(chatMember);
    }

    @Override
    public void broadcastMessage(ChatMember sender, String message) {
        for (ChatMember member : members) {
            if (member != sender) {
                member.receiveMessage(sender.getName() + ": " + message);
            }
        }
    }
}

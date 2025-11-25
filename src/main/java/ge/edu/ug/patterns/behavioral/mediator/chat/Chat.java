package ge.edu.ug.patterns.behavioral.mediator.chat;

import java.util.ArrayList;
import java.util.List;

public class Chat implements ChatMediator {
    List<ChatMember> members = new ArrayList<>();

    @Override
    public void addMember(ChatMember chatMember) {
        this.members.add(chatMember);
    }

    @Override
    public void removeMember(ChatMember chatMember) {
        this.members.remove(chatMember);
    }

    @Override
    public void broadcastMessage(ChatMember sender, String message) {
        System.out.printf("%s says: %s\n", sender.getName(), message);
        for (ChatMember member : members) {
            if(!member.equals(sender)) {
                member.receiveMessage(message);
            }
        }
    }
}

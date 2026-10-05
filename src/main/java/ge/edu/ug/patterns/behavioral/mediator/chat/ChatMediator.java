package ge.edu.ug.patterns.behavioral.mediator.chat;

// Mediator
public interface ChatMediator {
    void broadcastMessage(ChatMember sender, String message);

    void addMember(ChatMember chatMember);

    void removeMember(ChatMember chatMember);
}

package ge.edu.ug.patterns.behavioral.mediator.chat;

public interface ChatMediator {
    void broadcastMessage(ChatMember chatMember, String message);
    void addMember(ChatMember chatMember);
    void removeMember(ChatMember chatMember);
}

package ge.edu.ug.patterns.behavioral.mediator.chat;

public interface ChatMember {
    void receiveMessage(String message);
    void sendMessage(String message);
    String getName();
}

package ge.edu.ug.patterns.behavioral.mediator.chat;

import java.util.List;

public interface ChatMember {
    void receiveMessage(String message);

    void sendMessage(String message);

    String getName();

    List<String> getReceivedMessages();
}

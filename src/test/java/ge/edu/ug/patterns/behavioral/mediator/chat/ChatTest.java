package ge.edu.ug.patterns.behavioral.mediator.chat;

import org.junit.jupiter.api.Test;

class ChatTest {

    @Test
    void broadcastMessage() throws InterruptedException {
        ChatMediator mediator = new Chat();
        ChatMember user1 = new ConcreteMember("Giorgi 1", mediator);
        ChatMember user2 = new ConcreteMember("Sandro", mediator);
        ChatMember user3 = new ConcreteMember("Giorgi 2", mediator);
        ChatMember user4 = new ConcreteMember("Vamekh", mediator);

        user1.sendMessage("Great pattern!");
        Thread.sleep(1000);
        user2.sendMessage("Not really!");
        Thread.sleep(1000);
        user3.sendMessage("What's your concern?!");
        Thread.sleep(1000);
        user4.sendMessage("Tsssss, it is too loud!");
    }
}

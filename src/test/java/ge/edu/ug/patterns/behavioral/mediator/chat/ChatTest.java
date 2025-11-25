package ge.edu.ug.patterns.behavioral.mediator.chat;

import org.junit.jupiter.api.Test;

class ChatTest {

    @Test
    void broadcastMessage() {
        ChatMediator mediator = new Chat();
        ChatMember user1 = new ConcreteMember("Giorgi 1", mediator);
        ChatMember user2 = new ConcreteMember("Sandro", mediator);
        ChatMember user3 = new ConcreteMember("Giorgi 2", mediator);
        ChatMember user4 = new ConcreteMember("Vamekh", mediator);

        user1.sendMessage("რა კარგი პატერნია!");
        user2.sendMessage("არც ისე!");
        user3.sendMessage("რას ერჩი?!");
        user4.sendMessage("ხმაურია აუდიტორიაში!");
    }
}

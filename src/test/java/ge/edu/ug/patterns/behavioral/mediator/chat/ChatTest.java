package ge.edu.ug.patterns.behavioral.mediator.chat;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChatTest {

    @Test
    void broadcastMessage() {
        ChatMediator chat = new Chat();
        ConcreteMember giorgi = new ConcreteMember("Giorgi", chat);
        ConcreteMember sandro = new ConcreteMember("Sandro", chat);
        ConcreteMember vamekh = new ConcreteMember("Vamekh", chat);

        giorgi.sendMessage("Great pattern!");
        sandro.sendMessage("Not really!");

        // the sender never receives its own message
        assertEquals(List.of("Sandro: Not really!"), giorgi.getReceivedMessages());
        assertEquals(List.of("Giorgi: Great pattern!"), sandro.getReceivedMessages());
        assertEquals(List.of("Giorgi: Great pattern!", "Sandro: Not really!"), vamekh.getReceivedMessages());
    }

    @Test
    void leavingIsOneCallToTheMediator() {
        ChatMediator chat = new Chat();
        ConcreteMember giorgi = new ConcreteMember("Giorgi", chat);
        ConcreteMember sandro = new ConcreteMember("Sandro", chat);
        ConcreteMember vamekh = new ConcreteMember("Vamekh", chat);

        chat.removeMember(vamekh);
        giorgi.sendMessage("Bye Vamekh");

        assertEquals(List.of(), vamekh.getReceivedMessages());
        assertEquals(List.of("Giorgi: Bye Vamekh"), sandro.getReceivedMessages());
    }

    @Test
    void joiningNeedsNoChangeToExistingMembers() {
        ChatMediator chat = new Chat();
        ConcreteMember giorgi = new ConcreteMember("Giorgi", chat);
        ConcreteMember newcomer = new ConcreteMember("Nino", chat);

        giorgi.sendMessage("Welcome!");

        assertEquals(List.of("Giorgi: Welcome!"), newcomer.getReceivedMessages());
    }
}

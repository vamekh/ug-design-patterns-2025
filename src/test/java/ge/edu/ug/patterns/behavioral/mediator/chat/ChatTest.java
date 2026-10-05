package ge.edu.ug.patterns.behavioral.mediator.chat;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// PROBLEM: the test has to wire every pair of members itself (6 links for 3 people),
// and someone joining or leaving means touching every existing member.
class ChatTest {

    @Test
    void broadcastMessage() {
        ConcreteMember giorgi = new ConcreteMember("Giorgi");
        ConcreteMember sandro = new ConcreteMember("Sandro");
        ConcreteMember vamekh = new ConcreteMember("Vamekh");
        giorgi.addContact(sandro);
        giorgi.addContact(vamekh);
        sandro.addContact(giorgi);
        sandro.addContact(vamekh);
        vamekh.addContact(giorgi);
        vamekh.addContact(sandro);

        giorgi.sendMessage("Great pattern!");
        sandro.sendMessage("Not really!");

        assertEquals(List.of("Sandro: Not really!"), giorgi.getReceivedMessages());
        assertEquals(List.of("Giorgi: Great pattern!"), sandro.getReceivedMessages());
        assertEquals(List.of("Giorgi: Great pattern!", "Sandro: Not really!"), vamekh.getReceivedMessages());
    }

    @Test
    void leavingMeansUpdatingEveryone() {
        ConcreteMember giorgi = new ConcreteMember("Giorgi");
        ConcreteMember sandro = new ConcreteMember("Sandro");
        ConcreteMember vamekh = new ConcreteMember("Vamekh");
        giorgi.addContact(sandro);
        giorgi.addContact(vamekh);
        sandro.addContact(giorgi);
        sandro.addContact(vamekh);
        vamekh.addContact(giorgi);
        vamekh.addContact(sandro);

        // Vamekh leaves: every other member must drop him, otherwise he keeps receiving messages
        giorgi.removeContact(vamekh);
        sandro.removeContact(vamekh);
        giorgi.sendMessage("Bye Vamekh");

        assertEquals(List.of(), vamekh.getReceivedMessages());
        assertEquals(List.of("Giorgi: Bye Vamekh"), sandro.getReceivedMessages());
    }
}

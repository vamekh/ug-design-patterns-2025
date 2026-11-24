package ge.edu.ug.patterns.behavioral.visitor.traintickets;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    @Test
    void testVisitor() {
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new MembershipTicket());
        tickets.add(new OneWayTicket("გორი", "A"));
        tickets.add(new OneWayTicket("ხაშური", "B"));
        tickets.add(new OneWayTicket("კასპი", "B"));
        tickets.add(new DayTicket("B"));

        System.out.println("Section Validation:");
        TicketVisitor sectionValidationVisitor = new TrainSectionValidationVisitor("A");

        tickets.forEach(ticket -> ticket.accept(sectionValidationVisitor));
        System.out.println();
        System.out.println();
        TicketVisitor destinationValidationVisitor = new TicketDestinationValidationVisitor(List.of("გორი", "ხაშური", "ზესტაფონი", "ბათუმი"));

        tickets.forEach(ticket -> ticket.accept(destinationValidationVisitor));
    }

}

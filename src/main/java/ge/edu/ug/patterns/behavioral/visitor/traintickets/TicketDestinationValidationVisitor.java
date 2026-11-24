package ge.edu.ug.patterns.behavioral.visitor.traintickets;

import java.util.ArrayList;
import java.util.List;

public class TicketDestinationValidationVisitor implements TicketVisitor{
    private List<String> destinations;

    public TicketDestinationValidationVisitor(List<String> destinations) {
        this.destinations = destinations;
        if(destinations == null) {
            destinations = new ArrayList<>();
        }
    }

    @Override
    public void visit(DayTicket dayTicket) {
        System.out.println("Day ticket is valid for 24 hours from the time of purchase.");
    }

    @Override
    public void visit(MembershipTicket membershipTicket) {
        System.out.println("Membership ticket is valid for the duration of the membership.");
    }

    @Override
    public void visit(OneWayTicket oneWayTicket) {
        if(destinations.contains(oneWayTicket.getDestination())) {
            System.out.println("One-way ticket is valid for the destination: " + oneWayTicket.getDestination());
        } else {
            System.out.println("One-way ticket is not valid for the destination: " + oneWayTicket.getDestination());
        }
    }
}

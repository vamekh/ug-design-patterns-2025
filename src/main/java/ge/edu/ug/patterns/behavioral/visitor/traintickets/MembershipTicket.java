package ge.edu.ug.patterns.behavioral.visitor.traintickets;

public class MembershipTicket extends Ticket{
    @Override
    public void accept(TicketVisitor visitor) {
        visitor.visit(this);
    }
}

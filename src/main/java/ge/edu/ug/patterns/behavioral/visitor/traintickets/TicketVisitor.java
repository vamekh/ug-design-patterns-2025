package ge.edu.ug.patterns.behavioral.visitor.traintickets;

public interface TicketVisitor {
    void visit(MembershipTicket membershipTicket);
    void visit(DayTicket dayTicket);
    void visit(OneWayTicket oneWayTicket);
}

package ge.edu.ug.patterns.behavioral.visitor.traintickets;

public class DayTicket extends Ticket{

    public DayTicket(String section){
        super(section);
    }

    @Override
    public void accept(TicketVisitor visitor) {
        visitor.visit(this);
    }
}

package ge.edu.ug.patterns.behavioral.visitor.traintickets;

public class OneWayTicket extends Ticket{
    private String destination;

    public OneWayTicket(String destination, String section){
        super(section);
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public void accept(TicketVisitor visitor) {
        visitor.visit(this);
    }
}

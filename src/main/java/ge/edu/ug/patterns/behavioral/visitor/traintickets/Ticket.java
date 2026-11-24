package ge.edu.ug.patterns.behavioral.visitor.traintickets;

public abstract class Ticket {
    protected String section;

    public Ticket(){

    }

    public Ticket(String section) {
        this.section = section;
    }

    public String getSection() {
        return section;
    }

    public abstract void accept(TicketVisitor visitor);
}

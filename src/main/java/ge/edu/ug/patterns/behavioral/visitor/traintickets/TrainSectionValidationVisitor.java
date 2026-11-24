package ge.edu.ug.patterns.behavioral.visitor.traintickets;

public class TrainSectionValidationVisitor implements TicketVisitor {
    private String section;

    public TrainSectionValidationVisitor(String section) {
        this.section = section;
    }

    @Override
    public void visit(DayTicket dayTicket) {
        if(section == dayTicket.getSection()){
            System.out.println("Day ticket is valid for section: " + section);
        } else {
            System.out.println("Day ticket is not valid for section: " + section);
        }
    }

    @Override
    public void visit(MembershipTicket membershipTicket) {
        System.out.println("Membership ticket is valid for all sections.");
    }

    @Override
    public void visit(OneWayTicket oneWayTicket) {
        if(section == oneWayTicket.getSection()){
            System.out.println("One-way ticket is valid for section: " + section);
        } else {
            System.out.println("One-way ticket is not valid for section: " + section);
        }
    }
}

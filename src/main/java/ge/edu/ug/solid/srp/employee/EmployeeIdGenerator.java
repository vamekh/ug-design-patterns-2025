package ge.edu.ug.solid.srp.employee;

// Only responsibility: the id format. Sequential, so ids are unique and predictable.
public class EmployeeIdGenerator {
    private int next;

    public EmployeeIdGenerator() {
        this(1);
    }

    public EmployeeIdGenerator(int start) {
        this.next = start;
    }

    public String generateEmployeeId() {
        return String.format("EMP%03d", next++);
    }
}

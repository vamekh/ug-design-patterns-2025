package ge.edu.ug.patterns.structural.composite.orgchart;

// Component: every employee can report its own salary roll-up and headcount.
public abstract class Employee {
    private final String name;
    private final double salary;

    protected Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public abstract double getTotalSalary();

    public abstract int getHeadcount();
}

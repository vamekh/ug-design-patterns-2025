package ge.edu.ug.patterns.structural.composite.orgchart;

public class Designer {
    private final String name;
    private final double salary;

    public Designer(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}

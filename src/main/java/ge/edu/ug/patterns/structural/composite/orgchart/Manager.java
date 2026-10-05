package ge.edu.ug.patterns.structural.composite.orgchart;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private final String name;
    private final double salary;
    // Developers, Designers and Managers share no type, so the team is a List<Object>.
    private final List<Object> subordinates = new ArrayList<>();

    public Manager(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Manager add(Object subordinate) {
        subordinates.add(subordinate);
        return this;
    }

    public List<Object> getSubordinates() {
        return subordinates;
    }
}

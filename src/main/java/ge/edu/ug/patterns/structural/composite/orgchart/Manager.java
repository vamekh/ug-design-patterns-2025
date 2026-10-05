package ge.edu.ug.patterns.structural.composite.orgchart;

import java.util.ArrayList;
import java.util.List;

// Composite: a manager is an employee that also has subordinates.
public class Manager extends Employee {
    private final List<Employee> subordinates = new ArrayList<>();

    public Manager(String name, double salary) {
        super(name, salary);
    }

    public Manager add(Employee subordinate) {
        subordinates.add(subordinate);
        return this;
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    @Override
    public double getTotalSalary() {
        double total = getSalary();
        for (Employee subordinate : subordinates) {
            total += subordinate.getTotalSalary();
        }
        return total;
    }

    @Override
    public int getHeadcount() {
        int count = 1;
        for (Employee subordinate : subordinates) {
            count += subordinate.getHeadcount();
        }
        return count;
    }
}

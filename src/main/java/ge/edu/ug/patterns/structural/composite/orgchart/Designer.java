package ge.edu.ug.patterns.structural.composite.orgchart;

// Leaf
public class Designer extends Employee {

    public Designer(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double getTotalSalary() {
        return getSalary();
    }

    @Override
    public int getHeadcount() {
        return 1;
    }
}

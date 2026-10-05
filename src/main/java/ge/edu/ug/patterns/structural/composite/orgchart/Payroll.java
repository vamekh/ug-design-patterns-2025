package ge.edu.ug.patterns.structural.composite.orgchart;

// PROBLEM: Payroll has to know every employee class and walk the tree with instanceof.
// Adding a new role (e.g. Tester) means editing every method here, and a forgotten
// branch silently counts that person as 0 instead of failing to compile.
public class Payroll {

    public double getTotalSalary(Object employee) {
        if (employee instanceof Developer) {
            return ((Developer) employee).getSalary();
        } else if (employee instanceof Designer) {
            return ((Designer) employee).getSalary();
        } else if (employee instanceof Manager) {
            Manager manager = (Manager) employee;
            double total = manager.getSalary();
            for (Object subordinate : manager.getSubordinates()) {
                total += getTotalSalary(subordinate);
            }
            return total;
        }
        return 0;
    }

    public int getHeadcount(Object employee) {
        if (employee instanceof Developer || employee instanceof Designer) {
            return 1;
        } else if (employee instanceof Manager) {
            int count = 1;
            for (Object subordinate : ((Manager) employee).getSubordinates()) {
                count += getHeadcount(subordinate);
            }
            return count;
        }
        return 0;
    }
}

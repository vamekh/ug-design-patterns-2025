package ge.edu.ug.patterns.structural.composite.orgchart;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// PROBLEM: the client cannot ask an employee for its own total - it needs a Payroll that
// type-checks every node. Manager.add(Object) even accepts things that are not employees.
class OrgChartTest {

    private Manager buildOrg() {
        Manager cto = new Manager("Nino", 9000);
        Manager teamLead = new Manager("Giorgi", 6000)
                .add(new Developer("Luka", 4000))
                .add(new Developer("Mariam", 4200));
        return cto
                .add(teamLead)
                .add(new Designer("Ana", 3500));
    }

    @Test
    void totalSalaryRollsUpThroughTheTree() {
        Payroll payroll = new Payroll();
        assertEquals(26700, payroll.getTotalSalary(buildOrg()));
    }

    @Test
    void headcountIncludesManagers() {
        Payroll payroll = new Payroll();
        assertEquals(5, payroll.getHeadcount(buildOrg()));
    }

    @Test
    void unknownTypeIsSilentlyIgnored() {
        Manager boss = new Manager("Boss", 1000).add("not an employee");
        Payroll payroll = new Payroll();
        assertEquals(1000, payroll.getTotalSalary(boss));
        assertEquals(1, payroll.getHeadcount(boss));
    }
}

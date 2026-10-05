package ge.edu.ug.patterns.structural.composite.orgchart;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals(26700, buildOrg().getTotalSalary());
    }

    @Test
    void headcountIncludesManagers() {
        assertEquals(5, buildOrg().getHeadcount());
    }

    @Test
    void anySubtreeAnswersForItself() {
        Employee teamLead = buildOrg().getSubordinates().get(0);
        assertEquals(14200, teamLead.getTotalSalary());
        assertEquals(3, teamLead.getHeadcount());

        Employee designer = new Designer("Ana", 3500);
        assertEquals(3500, designer.getTotalSalary());
        assertEquals(1, designer.getHeadcount());
    }
}

package ge.edu.ug.solid.srp.employee;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmployeeTest {
    // This code complies with Single Responsibility Principle (SRP) by:
    // 1. Separating employee data management (Employee class)
    // 2. ID generation logic (EmployeeIdGenerator class)
    // 3. Seniority checking logic (SeniorityChecker class)
    // Each class has a single, well-defined responsibility

    @Test
    void displayEmployeeDetails() {
        Employee nikola = new Employee("Nikola", "Tesla", 10.0);
        EmployeeIdGenerator idGenerator = new EmployeeIdGenerator();
        nikola.setEmployeeId(idGenerator.generateEmployeeId());
        showEmpDetail(nikola);

        assertEquals("EMP001", nikola.getEmployeeId());
        assertEquals("senior", new SeniorityChecker().checkSeniority(nikola.getExperienceInYears()));
    }

    @Test
    void idGeneratorIsSequentialAndUnique() {
        EmployeeIdGenerator idGenerator = new EmployeeIdGenerator(41);

        assertEquals("EMP041", idGenerator.generateEmployeeId());
        assertEquals("EMP042", idGenerator.generateEmployeeId());
    }

    @Test
    void seniorityPolicyAlone() {
        SeniorityChecker seniorityChecker = new SeniorityChecker();

        assertEquals("junior", seniorityChecker.checkSeniority(4.9));
        assertEquals("senior", seniorityChecker.checkSeniority(5.0));
        assertThrows(IllegalArgumentException.class, () -> seniorityChecker.checkSeniority(-1));
    }

    private static void showEmpDetail(Employee emp) {
        // Display employee detail
        emp.displayEmployeeDetails();
        System.out.println("The employee id: " + emp.getEmployeeId());
        // Check the seniority level
        SeniorityChecker seniorityChecker = new SeniorityChecker();
        System.out.printf("This employee is a %s employee.", seniorityChecker.checkSeniority(emp.getExperienceInYears()));
    }
}

package ge.edu.ug.solid.srp.employee;

import org.junit.jupiter.api.Test;


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
        nikola.employeeId = idGenerator.generateEmployeeId();
        showEmpDetail(nikola);
    }

    private static void showEmpDetail(Employee emp) {
        // Display employee detail
        emp.displayEmployeeDetails();
        System.out.println("The employee id: " + emp.employeeId);
        // Check the seniority level
        SeniorityChecker seniorityChecker = new SeniorityChecker();
        System.out.printf("This employee is a %s employee.", seniorityChecker.checkSeniority(emp.experienceInYears));
    }
}

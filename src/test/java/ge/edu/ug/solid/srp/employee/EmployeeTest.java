package ge.edu.ug.solid.srp.employee;

import org.junit.jupiter.api.Test;

class EmployeeTest {
    // This test demonstrates violations of Single Responsibility Principle (SRP)
    // The Employee class has multiple responsibilities:
    // 1. Managing employee data (firstName, lastName, experience)
    // 2. Displaying employee information
    // 3. Determining employee seniority
    // 4. Generating employee IDs
    // These responsibilities should be separated into different classes
    @Test
    void testBadExample() {
        Employee erich = new Employee("Erich", "Gamma", 10.0);
        showEmployeeDetails(erich);
    }

    private void showEmployeeDetails(Employee employee) {
        employee.displayEmployeeDetails();
        employee.employeeId = employee.generateEmployeeId();

        System.out.printf("Employee id: %s\n", employee.employeeId);
        System.out.printf("This employee is a %s employee\n", employee.checkSeniority());
    }
}

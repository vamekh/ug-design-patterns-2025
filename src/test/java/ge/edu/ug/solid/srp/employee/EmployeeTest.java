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
        displayEmployeeDetails(erich);
        EmployeeSeniorityChecker checker = new EmployeeSeniorityChecker();
        System.out.println("Employee seniority: " + checker.checkSeniority(erich));
        IdGenerator generator = new IdGenerator();
        System.out.println("Employee ID: " + generator.generateId("EMP"));
    }

    public void displayEmployeeDetails(Employee employee) {
        System.out.println("Employee name: " + employee.firstName + " " + employee.lastName);
        System.out.printf("This employee has %f years of experience\n", employee.experienceInYears);
    }
}

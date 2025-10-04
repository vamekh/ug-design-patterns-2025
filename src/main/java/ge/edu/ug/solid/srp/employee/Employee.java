package ge.edu.ug.solid.srp.employee;

public class Employee {
    public String firstName, lastName, employeeId;
    public Double experienceInYears;

    public Employee(String firstName, String lastName, Double experienceInYears) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.experienceInYears = experienceInYears;
    }

    public void displayEmployeeDetails() {
        System.out.println("Employee name: " + this.firstName + " " + this.lastName);
        System.out.printf("This employee has %f years of experience\n", this.experienceInYears);
    }
}

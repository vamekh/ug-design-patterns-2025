package ge.edu.ug.solid.srp.employee;

public class Employee {
    private final String firstName, lastName;
    private final double experienceInYears;
    private String employeeId;

    public Employee(String firstName, String lastName, double experienceInYears) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.experienceInYears = experienceInYears;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getExperienceInYears() {
        return experienceInYears;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void displayEmployeeDetails() {
        System.out.println("Employee name: " + this.firstName + " " + this.lastName);
        System.out.printf("This employee has %f years of experience\n", this.experienceInYears);
    }
}

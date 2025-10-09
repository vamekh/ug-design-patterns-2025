package ge.edu.ug.solid.srp.employee;

public class EmployeeSeniorityChecker {
    private int limit = 5;

    public String checkSeniority(Employee employee) {
        if(employee.experienceInYears > limit) {
            return "Senior";
        }
        return "Junior";
    }
}

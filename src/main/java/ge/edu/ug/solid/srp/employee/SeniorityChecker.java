package ge.edu.ug.solid.srp.employee;

public class SeniorityChecker {
    public String checkSeniority(Double experienceInYears) {
        return experienceInYears >= 5 ? "senior" : "junior";
    }
}

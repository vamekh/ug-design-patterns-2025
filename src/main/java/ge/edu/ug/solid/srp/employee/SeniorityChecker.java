package ge.edu.ug.solid.srp.employee;

// Only responsibility: the seniority policy (5+ years means senior).
public class SeniorityChecker {
    public String checkSeniority(double experienceInYears) {
        if (experienceInYears < 0) {
            throw new IllegalArgumentException("Experience cannot be negative: " + experienceInYears);
        }
        return experienceInYears >= 5 ? "senior" : "junior";
    }
}

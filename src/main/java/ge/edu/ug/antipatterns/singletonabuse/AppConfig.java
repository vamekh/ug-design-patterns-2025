package ge.edu.ug.antipatterns.singletonabuse;

// SINGLETON ABUSE: a global, mutable configuration that anyone can read or change from anywhere.
// Classes that use it hide that dependency (their constructors look empty), and every test in the
// JVM shares the same instance - one test's setCurrency() silently breaks the next test.
public class AppConfig {
    private static AppConfig instance;

    private String currency = "GEL";
    private double taxRate = 0.18;

    private AppConfig() {
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    // Exists only so that tests can undo each other's changes.
    public void reset() {
        currency = "GEL";
        taxRate = 0.18;
    }
}

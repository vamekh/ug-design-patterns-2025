package ge.edu.ug.antipatterns.singletonabuse;

// Immutable value object: created once at the composition root and passed to whoever needs it.
// No getInstance(), no setters, no reset() - nothing global to leak between tests.
public final class Config {
    private final String currency;
    private final double taxRate;

    public Config(String currency, double taxRate) {
        this.currency = currency;
        this.taxRate = taxRate;
    }

    public String getCurrency() {
        return currency;
    }

    public double getTaxRate() {
        return taxRate;
    }
}

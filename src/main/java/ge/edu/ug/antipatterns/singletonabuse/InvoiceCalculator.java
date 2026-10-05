package ge.edu.ug.antipatterns.singletonabuse;

public class InvoiceCalculator {
    private final Config config;

    // explicit dependency: you cannot build a calculator without saying which config it uses
    public InvoiceCalculator(Config config) {
        this.config = config;
    }

    public double total(double net) {
        double taxRate = config.getTaxRate();
        return Math.round(net * (1 + taxRate) * 100) / 100.0;
    }
}

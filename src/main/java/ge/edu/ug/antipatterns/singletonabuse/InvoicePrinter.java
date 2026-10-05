package ge.edu.ug.antipatterns.singletonabuse;

public class InvoicePrinter {
    private final Config config;
    private final InvoiceCalculator calculator;

    public InvoicePrinter(Config config, InvoiceCalculator calculator) {
        this.config = config;
        this.calculator = calculator;
    }

    public String line(String customer, double net) {
        String currency = config.getCurrency();
        return customer + ": " + calculator.total(net) + " " + currency;
    }
}

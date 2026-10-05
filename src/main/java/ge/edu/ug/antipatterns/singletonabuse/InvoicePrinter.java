package ge.edu.ug.antipatterns.singletonabuse;

public class InvoicePrinter {
    private final InvoiceCalculator calculator = new InvoiceCalculator();

    public String line(String customer, double net) {
        // second hidden dependency on the same global
        String currency = AppConfig.getInstance().getCurrency();
        return customer + ": " + calculator.total(net) + " " + currency;
    }
}

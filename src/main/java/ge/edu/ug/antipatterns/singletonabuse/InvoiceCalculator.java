package ge.edu.ug.antipatterns.singletonabuse;

public class InvoiceCalculator {

    public double total(double net) {
        // hidden dependency: nothing in the constructor says we need a tax rate
        double taxRate = AppConfig.getInstance().getTaxRate();
        return Math.round(net * (1 + taxRate) * 100) / 100.0;
    }
}

package ge.edu.ug.solid.isp.printer;

import org.junit.jupiter.api.Test;

class PrinterTest {
    // This example follows Interface Segregation Principle (ISP) by:
    // - BasicPrinter implements only the print functionality it needs
    // - AdvancedPrinter implements both print and fax functionality
    // - No class is forced to implement methods it doesn't use

    @Test
    public void testIspGoodExample() {
        Printer basicPrinter = new BasicPrinter();
        basicPrinter.print();
        AdvancedPrinter advancedPrinter = new AdvancedPrinter();
        advancedPrinter.print();
        advancedPrinter.sendFax();
    }
}

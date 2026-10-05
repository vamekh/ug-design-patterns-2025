package ge.edu.ug.solid.isp.printer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class PrinterTest {
    // This example follows Interface Segregation Principle (ISP) by:
    // - BasicPrinter implements only the print functionality it needs
    // - AdvancedPrinter implements both print and fax functionality
    // - No class is forced to implement methods it doesn't use
    // - Clients depend only on the role they use: OfficeAssistant(Printer), FaxSender(Fax)

    @Test
    public void testIspGoodExample() {
        Printer basicPrinter = new BasicPrinter();
        assertEquals("Printing...", basicPrinter.print());
        AdvancedPrinter advancedPrinter = new AdvancedPrinter();
        assertEquals("The advanced printer prints a document.", advancedPrinter.print());
        assertEquals("The advanced printer sends a fax.", advancedPrinter.sendFax());
    }

    @Test
    public void basicPrinterServesPrintOnlyClient() {
        OfficeAssistant assistant = new OfficeAssistant(new BasicPrinter());

        assertEquals("Printing...", assistant.printReport());
        // new FaxSender(new BasicPrinter()); // does not compile: BasicPrinter is not a Fax
        assertFalse(Fax.class.isAssignableFrom(BasicPrinter.class));
    }

    @Test
    public void advancedPrinterServesBothClients() {
        AdvancedPrinter advancedPrinter = new AdvancedPrinter();

        assertEquals("The advanced printer prints a document.", new OfficeAssistant(advancedPrinter).printReport());
        assertEquals("The advanced printer sends a fax.", new FaxSender(advancedPrinter).sendContract());
    }
}

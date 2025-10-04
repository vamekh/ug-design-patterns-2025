package ge.edu.ug.solid.isp.printer;

import org.junit.jupiter.api.Test;

class PrinterTest {
    // This test demonstrates violation of Interface Segregation Principle (ISP)
    // The Printer interface forces BasicPrinter to implement sendFax() which it doesn't need
    // Instead, we should split the interface into smaller, specific interfaces
    
    @Test
    public void testBadExample() {
        System.out.println("***A demo without ISP.***");
        Printer printer = new AdvancedPrinter();
        printer.print();
        printer.sendFax();
        printer = new BasicPrinter();
        printer.print();
        printer.sendFax(); // Will throw error
    }
}

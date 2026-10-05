package ge.edu.ug.solid.isp.printer;

// Client that only faxes: depends on Fax alone, so the compiler rejects a device that can't fax.
public class FaxSender {
    private final Fax fax;

    public FaxSender(Fax fax) {
        this.fax = fax;
    }

    public String sendContract() {
        return fax.sendFax();
    }
}

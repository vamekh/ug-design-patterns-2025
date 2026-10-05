package ge.edu.ug.patterns.behavioral.chainofresponsibility.mail;

// Concrete Handler
public class EnvelopeSafetyValidator extends EnvelopeValidator {
    private final XRayScanner scanner;

    public EnvelopeSafetyValidator(XRayScanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public boolean handle(Envelope envelope) {
        System.out.println("Scanning the envelope with X-ray scanner");
        if (scanner.detectsBomb(envelope)) {
            System.out.println("Evacuation!!! Bomb detected!");
            return false;
        }
        return handleNext(envelope);
    }
}

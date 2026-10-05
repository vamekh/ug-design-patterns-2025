package ge.edu.ug.patterns.behavioral.chainofresponsibility.mail;

import java.util.Set;

// PROBLEM: accept() runs every validation itself, one if after another.
// Adding, removing or reordering a check means editing this method, and no check
// can be reused (e.g. a courier service that only needs address checks) or tested alone.
public class PostOffice {
    private static final Set<String> VALID_STAMPS = Set.of(
            "2000 year anniversary of Tbilisi",
            "22 year anniversary of UG"
    );
    private final XRayScanner scanner;

    public PostOffice(XRayScanner scanner) {
        this.scanner = scanner;
    }

    public boolean accept(Envelope envelope) {
        System.out.println("Validating stamp: " + envelope.stamp);
        if (!VALID_STAMPS.contains(envelope.stamp)) {
            System.out.println("Invalid stamp: " + envelope.stamp);
            return false;
        }
        System.out.println("Validating sender address: " + envelope.fromAddress);
        if (envelope.fromAddress == null || envelope.fromAddress.isBlank()) {
            System.out.println("Invalid sender address: " + envelope.fromAddress);
            return false;
        }
        System.out.println("Validating receiver address: " + envelope.toAddress);
        if (envelope.toAddress == null || envelope.toAddress.isBlank()) {
            System.out.println("Invalid receiver address: " + envelope.toAddress);
            return false;
        }
        System.out.println("Checking the content of the envelope");
        if (envelope.content == null || envelope.content.isBlank()) {
            System.out.println("Empty content! Rejecting the envelope");
            return false;
        }
        System.out.println("Scanning the envelope with X-ray scanner");
        if (scanner.detectsBomb(envelope)) {
            System.out.println("Evacuation!!! Bomb detected!");
            return false;
        }
        System.out.println("Envelope accepted");
        return true;
    }
}

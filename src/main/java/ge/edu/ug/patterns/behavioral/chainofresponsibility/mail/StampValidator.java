package ge.edu.ug.patterns.behavioral.chainofresponsibility.mail;

import java.util.Set;

// Concrete Handler
public class StampValidator extends EnvelopeValidator {
    private static final Set<String> VALID_STAMPS = Set.of(
            "2000 year anniversary of Tbilisi",
            "22 year anniversary of UG"
    );

    @Override
    public boolean handle(Envelope envelope) {
        System.out.println("Validating stamp: " + envelope.stamp);
        if (!VALID_STAMPS.contains(envelope.stamp)) {
            System.out.println("Invalid stamp: " + envelope.stamp);
            return false;
        }
        return handleNext(envelope);
    }
}

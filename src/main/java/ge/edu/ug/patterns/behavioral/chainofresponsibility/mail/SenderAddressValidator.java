package ge.edu.ug.patterns.behavioral.chainofresponsibility.mail;

// Concrete Handler
public class SenderAddressValidator extends EnvelopeValidator {

    @Override
    public boolean handle(Envelope envelope) {
        System.out.println("Validating sender address: " + envelope.fromAddress);
        if (envelope.fromAddress == null || envelope.fromAddress.isBlank()) {
            System.out.println("Invalid sender address: " + envelope.fromAddress);
            return false;
        }
        return handleNext(envelope);
    }
}

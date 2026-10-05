package ge.edu.ug.patterns.behavioral.chainofresponsibility.mail;

// Concrete Handler
public class ReceiverAddressValidator extends EnvelopeValidator {

    @Override
    public boolean handle(Envelope envelope) {
        System.out.println("Validating receiver address: " + envelope.toAddress);
        if (envelope.toAddress == null || envelope.toAddress.isBlank()) {
            System.out.println("Invalid receiver address: " + envelope.toAddress);
            return false;
        }
        return handleNext(envelope);
    }
}

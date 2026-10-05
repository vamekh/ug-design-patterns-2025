package ge.edu.ug.patterns.behavioral.chainofresponsibility.mail;

// Concrete Handler
public class ContentValidator extends EnvelopeValidator {

    @Override
    public boolean handle(Envelope envelope) {
        System.out.println("Checking the content of the envelope");
        if (envelope.content == null || envelope.content.isBlank()) {
            System.out.println("Empty content! Rejecting the envelope");
            return false;
        }
        return handleNext(envelope);
    }
}

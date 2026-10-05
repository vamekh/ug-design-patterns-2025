package ge.edu.ug.patterns.behavioral.chainofresponsibility.mail;

// Handler: one check per subclass, linked into a chain
public abstract class EnvelopeValidator {
    protected EnvelopeValidator next;

    public EnvelopeValidator setNext(EnvelopeValidator next) {
        this.next = next;
        return next;
    }

    public abstract boolean handle(Envelope envelope);

    protected boolean handleNext(Envelope envelope) {
        if (next == null) {
            return true;
        }
        return next.handle(envelope);
    }
}

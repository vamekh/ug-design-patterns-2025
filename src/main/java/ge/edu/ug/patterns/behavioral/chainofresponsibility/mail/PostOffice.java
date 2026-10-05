package ge.edu.ug.patterns.behavioral.chainofresponsibility.mail;

// Client: assembles the chain and hands every envelope to its first link
public class PostOffice {
    private final EnvelopeValidator chain;

    public PostOffice(XRayScanner scanner) {
        chain = new StampValidator();
        chain.setNext(new SenderAddressValidator())
                .setNext(new ReceiverAddressValidator())
                .setNext(new ContentValidator())
                .setNext(new EnvelopeSafetyValidator(scanner));
    }

    public boolean accept(Envelope envelope) {
        boolean accepted = chain.handle(envelope);
        if (accepted) {
            System.out.println("Envelope accepted");
        }
        return accepted;
    }
}

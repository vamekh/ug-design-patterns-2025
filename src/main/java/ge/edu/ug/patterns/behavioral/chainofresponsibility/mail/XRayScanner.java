package ge.edu.ug.patterns.behavioral.chainofresponsibility.mail;

import java.util.Random;

// Injected so tests can decide what the scanner "sees"
public interface XRayScanner {
    boolean detectsBomb(Envelope envelope);

    static XRayScanner random(Random random) {
        return envelope -> random.nextInt(10) == 1;
    }
}

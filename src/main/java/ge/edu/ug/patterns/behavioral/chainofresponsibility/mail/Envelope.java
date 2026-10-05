package ge.edu.ug.patterns.behavioral.chainofresponsibility.mail;

public class Envelope {
    String stamp;
    String toAddress;
    String fromAddress;
    String content;

    public Envelope(String stamp, String toAddress, String fromAddress, String content) {
        this.stamp = stamp;
        this.toAddress = toAddress;
        this.fromAddress = fromAddress;
        this.content = content;
    }
}

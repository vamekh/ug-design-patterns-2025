package ge.edu.ug;

public class DocumentContext {
    private DocumentState state;

    public DocumentContext() {

    }

    public void setState(DocumentState state) {
        this.state = state;
    }

    public void render(Document document) {
        state.render(this, document);
    }

    public void review(Document document) {
        state.review(this, document);
    }

    public void publish(Document document) {
        state.publish(this, document);
    }

    public void startRevision(Document document) {
        state.startRevision(this, document);
    }
}

package ge.edu.ug;

public interface DocumentState {
    void render(DocumentContext documentContext, Document document);
    void review(DocumentContext documentContext, Document document);
    void publish(DocumentContext documentContext, Document document);
    void startRevision(DocumentContext documentContext, Document document);
}

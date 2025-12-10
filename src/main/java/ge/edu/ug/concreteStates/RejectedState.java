package ge.edu.ug.concreteStates;

import state.Document;
import state.DocumentContext;
import state.DocumentState;

public class RejectedState implements DocumentState {
    @Override
    public void render(DocumentContext documentContext, Document document) {
        System.out.println("Document #" + document.getDocumentId() + " is rejected");
    }

    @Override
    public void review(DocumentContext documentContext, Document document) {
        System.out.println("Cannot review rejected document");
    }

    @Override
    public void publish(DocumentContext documentContext, Document document) {
        System.out.println("Cannot publish rejected document");
    }

    @Override
    public void startRevision(DocumentContext documentContext, Document document) {
        System.out.println("Revision started. Moving back to DraftState.");
        documentContext.setState(new DraftState());
    }
}

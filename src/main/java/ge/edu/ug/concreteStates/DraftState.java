package ge.edu.ug.concreteStates;

import state.Document;
import state.DocumentContext;
import state.DocumentState;

public class DraftState implements DocumentState {
    @Override
    public void render(DocumentContext documentContext, Document document) {
        System.out.println("Document #" + document.getDocumentId() + " is in draft");
    }

    @Override
    public void review(DocumentContext documentContext, Document document) {
        System.out.println("Document #" + document.getDocumentId() + " is moving to InReviewState");
        documentContext.setState(new InReviewState());
    }

    @Override
    public void publish(DocumentContext documentContext, Document document) {
        System.out.println("Cannot publish a draft!");
    }

    @Override
    public void startRevision(DocumentContext documentContext, Document document) {
        System.out.println("Document is already in draft, no revision is needed");
    }
}
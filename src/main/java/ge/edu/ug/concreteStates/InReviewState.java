package ge.edu.ug.concreteStates;

import state.Document;
import state.DocumentContext;
import state.DocumentState;

public class InReviewState implements DocumentState {
    @Override
    public void render(DocumentContext documentContext, Document document) {
        System.out.println("Document #" + document.getDocumentId() + " is in review (awaiting feedback)");
    }

    @Override
    public void review(DocumentContext documentContext, Document document) {
        if (document.isFeedbackGatheringComplete()) {
            System.out.println("Document #" + document.getDocumentId() + " is moving to ReviewCompletedState");
            documentContext.setState(new ReviewCompletedState());
        } else {
            System.out.println("Cannot proceed: still waiting for feedback");
        }
    }

    @Override
    public void publish(DocumentContext documentContext, Document document) {
        System.out.println("Cannot publish! A document is still under review");
    }

    @Override
    public void startRevision(DocumentContext documentContext, Document document) {
        System.out.println("Cannot start revision while document is under review");
    }
}

package ge.edu.ug.concreteStates;

import state.Document;
import state.DocumentContext;
import state.DocumentState;

public class ReviewCompletedState implements DocumentState {
    @Override
    public void render(DocumentContext documentContext, Document document) {
        System.out.println("Document #" + document.getDocumentId() + " review completed");
    }

    @Override
    public void review(DocumentContext documentContext, Document document) {
        if (document.isReviewApproved()) {
            System.out.println("Review is complete and was approved. Waiting for publish command");
        } else {
            System.out.println("Review is complete and was rejected. Document will be rejected.");
        }
    }

    @Override
    public void publish(DocumentContext documentContext, Document document) {
        if (document.isReviewApproved()) {
            System.out.println("Document #" + document.getDocumentId() + " is moving to PublishedState");
            documentContext.setState(new PublishedState());
        } else {
            System.out.println("Document #" + document.getDocumentId() + " is moving to RejectedState");
            documentContext.setState(new RejectedState());
        }
    }

    @Override
    public void startRevision(DocumentContext documentContext, Document document) {
        System.out.println("Cannot start revision while document is pending final decision");
    }
}

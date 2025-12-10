package ge.edu.ug.concreteStates;

import state.Document;
import state.DocumentContext;
import state.DocumentState;

public class PublishedState implements DocumentState {

    @Override
    public void render(DocumentContext documentContext, Document document) {
        System.out.println("Document #" + document.getDocumentId() + " is published");
    }

    @Override
    public void review(DocumentContext documentContext, Document document) {
        System.out.println("Cannot review a published document!");
    }

    @Override
    public void publish(DocumentContext documentContext, Document document) {
        System.out.println("Document is already published");
    }

    @Override
    public void startRevision(DocumentContext documentContext, Document document) {
        System.out.println("Starting revision for next document version...");
        documentContext.setState(new DraftState());
    }
}

package ge.edu.ug;

import state.concreteStates.DraftState;

public class Client {
    public static void main(String[] args) {
        DocumentContext context = new DocumentContext();
        Document document = new Document(
                "Document1",
                "LONG CONTENT......",
                294785
        );

        DraftState draftState = new DraftState();

        context.setState(draftState);

        context.render(document);
        context.publish(document);
        context.review(document);

        context.render(document);
        context.publish(document);

        context.review(document);

        document.setFeedbackGatheringComplete(true);
        context.review(document);

        context.render(document);
        context.review(document);

        document.setReviewApproved(true);
        context.review(document);
        context.publish(document);

        context.render(document);
        context.review(document);
        context.publish(document);

        context.startRevision(document);
        context.render(document);
    }
}

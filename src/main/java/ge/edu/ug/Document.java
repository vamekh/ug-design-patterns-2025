package ge.edu.ug;

public class Document {
    private String title;
    private String content;
    private int documentId;
    private boolean isReviewApproved;
    private boolean isFeedbackGatheringComplete;

    public Document(String title, String content, int documentId) {
        this.title = title;
        this.content = content;
        this.documentId = documentId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getDocumentId() {
        return documentId;
    }

    public boolean isReviewApproved() {
        return isReviewApproved;
    }

    public void setReviewApproved(boolean reviewApproved) {
        isReviewApproved = reviewApproved;
    }

    public boolean isFeedbackGatheringComplete() {
        return isFeedbackGatheringComplete;
    }

    public void setFeedbackGatheringComplete(boolean feedbackGatheringComplete) {
        isFeedbackGatheringComplete = feedbackGatheringComplete;
    }
}

package ge.edu.ug.patterns.behavioral.mediator.onlinejoker;

public interface JokerMediator {
    // Returns false when the move is refused (not the player's turn, or no game running)
    boolean broadcastMove(JokerMember sender, Card card);

    void addMember(JokerMember jokerMember);

    void removeMember(JokerMember jokerMember);

    void startNewGame();

    void stopGame(String reason);

    boolean isGameRunning();
}

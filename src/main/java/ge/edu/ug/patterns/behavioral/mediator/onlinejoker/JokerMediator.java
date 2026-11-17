package ge.edu.ug.patterns.behavioral.mediator.onlinejoker;

public interface JokerMediator {
    void broadcastMessage(JokerMember sender, String card);

    void addMember(JokerMember jokerMember);

    void removeMember(JokerMember jokerMember);

    void startNewGame();

    void stopGame(String reason);

    boolean isGameRunning();
}

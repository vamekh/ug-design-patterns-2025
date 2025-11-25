package ge.edu.ug.patterns.behavioral.memento.gameplay;

import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    void testMemento() {
        System.out.println("Game starts...");
        Game myGame = new Game(100, 0);
        System.out.println(myGame);
        myGame.shoot();
        myGame.changePosition(5);
        myGame.takeDamage(5);
        myGame.shoot();
        myGame.shoot();

        Game.GameMemento snapshot = myGame.save();
        System.out.println("Saving game state...");
        System.out.println(myGame);
        HistoryManager historyManager = new HistoryManager();
        historyManager.saveState(myGame);
        System.out.println("Continuing game...");
        myGame.changePosition(10);
        myGame.takeDamage(20);
        myGame.shoot();
        System.out.println("Current game state:");
        System.out.println(myGame);
        myGame.restore(historyManager.restoreState(0));
        System.out.println("After restore:");
        System.out.println(myGame);
    }
}

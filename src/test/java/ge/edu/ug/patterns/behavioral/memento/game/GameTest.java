package ge.edu.ug.patterns.behavioral.memento.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameTest {

    @Test
    void undoRestoresTheWholeState() {
        Game game = new Game(100, 0);
        game.shoot();
        game.changePosition(5);
        game.takeDamage(5);
        HistoryManager history = new HistoryManager();
        history.save(game);                    // health=95, position=5, bullets=9

        game.changePosition(10);
        game.takeDamage(20);
        game.shoot();
        game.shoot();
        history.undo(game);

        assertEquals(95, game.getHealth());
        assertEquals(5, game.getShooterPosition());
        assertEquals(9, game.getBullets());    // Game copies its own fields, nothing is forgotten
    }

    @Test
    void undoWorksAsAStack() {
        Game game = new Game(100, 0);
        HistoryManager history = new HistoryManager();
        history.save(game);
        game.takeDamage(10);
        history.save(game);
        game.takeDamage(10);

        assertTrue(history.undo(game));
        assertEquals(90, game.getHealth());
        assertTrue(history.undo(game));
        assertEquals(100, game.getHealth());
        assertFalse(history.undo(game));       // nothing left to undo
    }
}

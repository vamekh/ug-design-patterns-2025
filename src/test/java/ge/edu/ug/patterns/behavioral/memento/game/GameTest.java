package ge.edu.ug.patterns.behavioral.memento.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// PROBLEM: restoring works only for the fields HistoryManager remembered to copy,
// and the public setters let any code put Game into an impossible state.
class GameTest {

    @Test
    void undoRestoresCopiedFieldsButForgetsBullets() {
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
        assertEquals(7, game.getBullets());    // BUG: should be 9, bullets were never saved
    }

    @Test
    void settersBreakEncapsulation() {
        Game game = new Game(100, 0);
        game.setBullets(-5);                   // compiles fine: nothing protects Game's invariants
        assertEquals(-5, game.getBullets());
    }
}

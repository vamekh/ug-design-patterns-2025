package ge.edu.ug.patterns.structural.facade.hometheatre;

import ge.edu.ug.testutil.ConsoleCapture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

// There is no single entry point: the client must know all four devices and call
// seven methods in exactly the right order to start a film and four more (reversed)
// to stop it. Every client that wants to watch a film repeats this choreography.
class HomeTheatreTest {
    private Projector projector;
    private RollupScreen screen;
    private DvdPlayer dvdPlayer;
    private SoundSystem soundSystem;

    @BeforeEach
    void setUp() {
        projector = new Projector();
        screen = new RollupScreen();
        dvdPlayer = new DvdPlayer();
        soundSystem = new SoundSystem();
    }

    @Test
    void watchFilm() {
        String out = ConsoleCapture.run(() -> {
            screen.rollDown();
            projector.on();
            soundSystem.on();
            soundSystem.setVolume(50);
            dvdPlayer.on();
            projector.setInput("DVD");
            dvdPlayer.play("Mulholland Dr.");

            dvdPlayer.off();
            soundSystem.off();
            projector.off();
            screen.rollUp();
        });

        assertInOrder(out,
                "Screen rolled down", "Projector on", "Sound system on", "Sound system set volume to 50",
                "DvdPlayer on", "Projector input set to DVD", "DvdPlayer playing Mulholland Dr.",
                "DvdPlayer off", "Sound system off", "Projector off", "Screen rolled up");
    }

    private static void assertInOrder(String out, String... steps) {
        int from = 0;
        for (String step : steps) {
            int at = out.indexOf(step, from);
            assertTrue(at >= 0, "missing or out of order: " + step + "\n" + out);
            from = at + step.length();
        }
    }
}

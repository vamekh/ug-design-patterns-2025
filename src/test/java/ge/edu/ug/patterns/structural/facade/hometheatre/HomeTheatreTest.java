package ge.edu.ug.patterns.structural.facade.hometheatre;

import ge.edu.ug.testutil.ConsoleCapture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

// The client makes two calls; the facade knows the devices and the right order.
class HomeTheatreTest {
    private HomeTheatreFacade homeTheatre;

    @BeforeEach
    void setUp() {
        homeTheatre = new HomeTheatreFacade(
                new Projector(),
                new RollupScreen(),
                new DvdPlayer(),
                new SoundSystem()
        );
    }

    @Test
    void watchFilm() {
        String out = ConsoleCapture.run(() -> {
            homeTheatre.beginFilmSession("Mulholland Dr.");

            homeTheatre.endFilmSession();
        });

        assertInOrder(out,
                "Screen rolled down", "Projector on", "Sound system on", "Sound system set volume to 50",
                "DvdPlayer on", "Projector input set to DVD", "DvdPlayer playing Mulholland Dr.",
                "DvdPlayer off", "Sound system off", "Projector off", "Screen rolled up");
    }

    @Test
    void bannerFitsLongFilmNames() {
        String longTitle = "The Lord of the Rings: The Return of the King";

        String out = ConsoleCapture.run(() -> homeTheatre.beginFilmSession(longTitle));

        assertTrue(out.contains("|The Lord of the Rings: Th...|"), out);
    }

    @Test
    void bannerCentersShortFilmNames() {
        String out = ConsoleCapture.run(() -> homeTheatre.beginFilmSession("Up"));

        assertTrue(out.contains("|" + " ".repeat(13) + "Up" + " ".repeat(13) + "|"), out);
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

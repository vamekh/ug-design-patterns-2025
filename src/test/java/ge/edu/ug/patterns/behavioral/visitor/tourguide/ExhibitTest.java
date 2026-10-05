package ge.edu.ug.patterns.behavioral.visitor.tourguide;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Works, but each activity is spread over all exhibit classes.
// To let the photographer in we would have to add photograph() to Exhibit, Art, Artifact and WaxFigure.
class ExhibitTest {

    private final List<Exhibit> exhibits = List.of(
            new Art("Starry Night"),
            new Artifact("Ancient Egyptian Sarcophagus"),
            new WaxFigure("Albert Einstein")
    );

    @Test
    void testGuiding() {
        List<String> notes = exhibits.stream().map(Exhibit::guide).toList();

        assertEquals(List.of(
                "The tour guide talks about the painter of Starry Night and the art era",
                "The tour guide talks about the history and significance of Ancient Egyptian Sarcophagus",
                "The tour guide talks about the life of Albert Einstein and how the wax figure was made"
        ), notes);
    }

    @Test
    void testCleaning() {
        List<String> notes = exhibits.stream().map(Exhibit::clean).toList();

        assertEquals(List.of(
                "The cleaning staff carefully cleans the art piece Starry Night, ensuring no damage is done",
                "The cleaning staff carefully cleans the artifact Ancient Egyptian Sarcophagus, ensuring no damage is done",
                "Wax figure Albert Einstein is skipped. Cleaning not allowed"
        ), notes);
    }
}

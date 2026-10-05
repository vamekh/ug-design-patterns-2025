package ge.edu.ug.patterns.behavioral.visitor.tourguide;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExhibitTest {

    private final List<Exhibit> exhibits = List.of(
            new Art("Starry Night"),
            new Artifact("Ancient Egyptian Sarcophagus"),
            new WaxFigure("Albert Einstein")
    );

    private List<String> tour(ExhibitVisitor visitor) {
        exhibits.forEach(exhibit -> exhibit.accept(visitor));
        return visitor.getNotes();
    }

    @Test
    void testGuiding() {
        List<String> notes = tour(new ExhibitGuidingVisitor());

        assertEquals(List.of(
                "The tour guide talks about the painter of Starry Night and the art era",
                "The tour guide talks about the history and significance of Ancient Egyptian Sarcophagus",
                "The tour guide talks about the life of Albert Einstein and how the wax figure was made"
        ), notes);
    }

    @Test
    void testCleaning() {
        List<String> notes = tour(new ExhibitCleaningVisitor());

        assertEquals(List.of(
                "The cleaning staff carefully cleans the art piece Starry Night, ensuring no damage is done",
                "The cleaning staff carefully cleans the artifact Ancient Egyptian Sarcophagus, ensuring no damage is done",
                "Wax figure Albert Einstein is skipped. Cleaning not allowed"
        ), notes);
    }

    @Test
    void testPhotographingIsJustANewVisitor() {
        List<String> notes = tour(new ExhibitPhotographingVisitor());

        assertEquals(List.of(
                "The photographer shoots Starry Night without flash to protect the paint",
                "The photographer shoots Ancient Egyptian Sarcophagus from every side",
                "The photographer takes a selfie with Albert Einstein"
        ), notes);
    }
}

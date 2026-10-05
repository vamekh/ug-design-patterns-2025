package ge.edu.ug.antipatterns.goldenhammer;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

// Same scenarios, one call each. No factory, no context, no strategy objects.
class DateFormatsTest {
    private static final LocalDate WOMENS_DAY = LocalDate.of(2025, 3, 8);

    @Test
    void formatsIso() {
        assertEquals("2025-03-08", DateFormats.format(WOMENS_DAY, DateFormats.Style.ISO));
    }

    @Test
    void formatsGeorgian() {
        assertEquals("08.03.2025", DateFormats.format(WOMENS_DAY, DateFormats.Style.GEORGIAN));
    }

    @Test
    void rejectsUnknownFormat() {
        // with the enum a typo usually fails to COMPILE; parsing user input still throws
        assertThrows(IllegalArgumentException.class, () -> DateFormats.Style.valueOf("US"));
    }
}

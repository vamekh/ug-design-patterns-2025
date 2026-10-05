package ge.edu.ug.antipatterns.goldenhammer;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

// To format one date we need a factory, a strategy and a context: three objects and six types
// for what is a single DateTimeFormatter call. The "flexibility" was never used.
class DateFormatsTest {
    private static final LocalDate WOMENS_DAY = LocalDate.of(2025, 3, 8);

    private static String format(LocalDate date, String type) {
        DateFormatStrategyFactory factory = new DateFormatStrategyFactory();
        DateFormatterContext context = new DateFormatterContext(factory.create(type));
        return context.format(date);
    }

    @Test
    void formatsIso() {
        assertEquals("2025-03-08", format(WOMENS_DAY, "iso"));
    }

    @Test
    void formatsGeorgian() {
        assertEquals("08.03.2025", format(WOMENS_DAY, "georgian"));
    }

    @Test
    void rejectsUnknownFormat() {
        // a typo in the string is only caught at runtime
        assertThrows(IllegalArgumentException.class, () -> format(WOMENS_DAY, "US"));
    }
}

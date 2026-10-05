package ge.edu.ug.antipatterns.goldenhammer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// KISS: two formats need an enum and one method, not Strategy + Factory + Context.
// If a third, genuinely different algorithm ever appears, THEN consider a pattern.
public final class DateFormats {

    public enum Style {
        ISO(DateTimeFormatter.ISO_LOCAL_DATE),
        GEORGIAN(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        private final DateTimeFormatter formatter;

        Style(DateTimeFormatter formatter) {
            this.formatter = formatter;
        }
    }

    private DateFormats() {
    }

    public static String format(LocalDate date, Style style) {
        return date.format(style.formatter);
    }
}

package ge.edu.ug.antipatterns.goldenhammer;

import java.time.format.DateTimeFormatter;

public class GeorgianDateFormatStrategy extends AbstractDateFormatStrategy {

    @Override
    protected DateTimeFormatter formatter() {
        return DateTimeFormatter.ofPattern("dd.MM.yyyy");
    }
}

package ge.edu.ug.antipatterns.goldenhammer;

import java.time.format.DateTimeFormatter;

public class IsoDateFormatStrategy extends AbstractDateFormatStrategy {

    @Override
    protected DateTimeFormatter formatter() {
        return DateTimeFormatter.ISO_LOCAL_DATE;
    }
}

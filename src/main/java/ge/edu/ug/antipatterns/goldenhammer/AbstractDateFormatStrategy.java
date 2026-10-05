package ge.edu.ug.antipatterns.goldenhammer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// "In case we need shared behaviour later" - we never did.
public abstract class AbstractDateFormatStrategy implements DateFormatStrategy {

    protected abstract DateTimeFormatter formatter();

    @Override
    public String format(LocalDate date) {
        return date.format(formatter());
    }
}

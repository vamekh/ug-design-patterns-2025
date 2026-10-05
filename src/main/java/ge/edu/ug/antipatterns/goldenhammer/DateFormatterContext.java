package ge.edu.ug.antipatterns.goldenhammer;

import java.time.LocalDate;

public class DateFormatterContext {
    private DateFormatStrategy strategy;

    public DateFormatterContext(DateFormatStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(DateFormatStrategy strategy) {
        this.strategy = strategy;
    }

    public String format(LocalDate date) {
        return strategy.format(date);
    }
}

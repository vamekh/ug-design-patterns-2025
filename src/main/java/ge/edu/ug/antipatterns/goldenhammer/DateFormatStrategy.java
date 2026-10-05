package ge.edu.ug.antipatterns.goldenhammer;

import java.time.LocalDate;

// GOLDEN HAMMER: "we know Strategy and Factory, so let's use them" - for formatting a date two ways.
// Six types (interface, abstract base, two strategies, factory, context) wrap what is really one
// DateTimeFormatter call. Every reader must jump through all of them to see the actual pattern string.
public interface DateFormatStrategy {
    String format(LocalDate date);
}

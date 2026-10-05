package ge.edu.ug.antipatterns.goldenhammer;

public class DateFormatStrategyFactory {

    public DateFormatStrategy create(String type) {
        switch (type) {
            case "iso":
                return new IsoDateFormatStrategy();
            case "georgian":
                return new GeorgianDateFormatStrategy();
            default:
                throw new IllegalArgumentException("Unknown date format: " + type);
        }
    }
}

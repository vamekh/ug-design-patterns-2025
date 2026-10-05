package ge.edu.ug.patterns.creational.builder.car;

// Director: one definition per preset, works with any CarBuildable (CarDto, CarEntity, ...)
public class PopularModelsDirector {

    public <T> CarBuildable<T> buildSubaruForester(CarBuildable<T> builder) {
        return builder.brand("Subaru")
                .model("Forester")
                .seats(5);
    }

    public <T> CarBuildable<T> buildHondaFit(CarBuildable<T> builder) {
        return builder.brand("Honda")
                .model("Fit")
                .seats(4);
    }
}

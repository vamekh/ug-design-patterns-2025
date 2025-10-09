package ge.edu.ug.patterns.creational.builder.car;

public class PopularModelsDirector {
    public CarBuildable buildSubaruForester(CarBuildable builder) {
        builder.brand("Subaru")
                .model("Forester")
                .seats(5);
        return builder;
    }
    public CarBuildable buildHondaFit(CarBuildable builder) {
        builder.brand("Honda")
                .model("Fit")
                .seats(4);
        return builder;
    }
}

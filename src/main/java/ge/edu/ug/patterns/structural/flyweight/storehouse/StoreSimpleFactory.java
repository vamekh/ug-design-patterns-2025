package ge.edu.ug.patterns.structural.flyweight.storehouse;

public class StoreSimpleFactory {

    public static Box createBox(String size) {
        switch (size) {
            case "s":
                return new Box(10, 10, 10, "cardboard", "brown");
            case "m":
                return new Box(20, 20, 20, "cardboard", "brown");
            case "m-metal":
                return new Box(20, 20, 20, "metal", "silver");
            case "l":
                return new Box(30, 30, 30, "cardboard", "brown");
            default:
                throw new IllegalArgumentException("Unknown box size: " + size);
        }
    }
}

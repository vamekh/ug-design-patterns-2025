package ge.edu.ug.patterns.structural.flyweight.forestgame;

public class PineTree extends Tree{
    public PineTree(int locationX, int locationY, int height) {
        super(locationX, locationY, height, "brown", "Pine", "needles", "vertical");

        this.locationX = locationX;
        this.locationY = locationY;
        this.height = height;
    }

    @Override
    public String toString() {
        return "🌲";
    }
}

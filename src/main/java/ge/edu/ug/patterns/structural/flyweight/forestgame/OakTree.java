package ge.edu.ug.patterns.structural.flyweight.forestgame;

public class OakTree extends Tree{
    public OakTree(int locationX, int locationY, int height) {
        super(locationX, locationY, height, "gray", "Oak", "broadleaf", "spreading");

        this.locationX = locationX;
        this.locationY = locationY;
        this.height = height;
    }

    @Override
    public String toString() {
        return "🌳";
    }
}

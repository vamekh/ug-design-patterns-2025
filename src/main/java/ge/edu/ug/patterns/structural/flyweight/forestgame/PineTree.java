package ge.edu.ug.patterns.structural.flyweight.forestgame;

public class PineTree extends Tree{
    public PineTree(int locationX, int locationY, int height) {
        super(locationX, locationY, height, TreeCommonPropsFactory.get(PineTree.class.getSimpleName()));
    }

    @Override
    public String toString() {
        return "🌲";
    }
}

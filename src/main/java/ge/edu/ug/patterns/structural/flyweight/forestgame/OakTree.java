package ge.edu.ug.patterns.structural.flyweight.forestgame;

public class OakTree extends Tree{
    public OakTree(int locationX, int locationY, int height) {
        super(locationX, locationY, height, TreeCommonPropsFactory.get(OakTree.class.getSimpleName()));
    }

    @Override
    public String toString() {
        return "🌳";
    }
}

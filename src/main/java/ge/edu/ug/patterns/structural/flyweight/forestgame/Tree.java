package ge.edu.ug.patterns.structural.flyweight.forestgame;

// Context: keeps only the extrinsic state (unique per tree) and a reference to the shared flyweight.
public abstract class Tree {
    public int locationX;
    public int locationY;
    public int height;
    private final TreeCommonProps commonProps;

    public Tree(int locationX, int locationY, int height, TreeCommonProps commonProps) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.height = height;
        this.commonProps = commonProps;
    }

    public TreeCommonProps getCommonProps() {
        return commonProps;
    }

    // Rendering combines intrinsic (shared) and extrinsic (own) state.
    public void render(){
        System.out.printf("Rendering %s tree (%s bark, %s leaves, %s roots) on location: %d,%d, height: %d\n",
                commonProps.getSpecies(), commonProps.getBarkColor(), commonProps.getLeafType(),
                commonProps.getRootsType(), locationX, locationY, height);
    }
}

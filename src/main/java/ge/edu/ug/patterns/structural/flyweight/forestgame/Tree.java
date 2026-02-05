package ge.edu.ug.patterns.structural.flyweight.forestgame;

public abstract class Tree implements TreeComonProps{
    public int locationX;
    public int locationY;
    public int height;
    private TreeComonProps comonProps;



    public Tree(int locationX, int locationY, int height, TreeComonProps comonProps) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.height = height;
        this.comonProps = comonProps;
    }

    @Override
    public String getBarkColor() {
        return comonProps.getBarkColor();
    }
    @Override
    public String getSpecie() {
        return comonProps.getSpecie();
    }
    @Override
    public String getLeafType() {
        return comonProps.getLeafType();
    }
    @Override
    public String getRootsType() {
        return comonProps.getRootsType();
    }


    public void render(){
        System.out.printf("Rendering tree on location: %d,%d\n", locationX, locationY);
    }
}

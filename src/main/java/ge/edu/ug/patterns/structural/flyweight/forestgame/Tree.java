package ge.edu.ug.patterns.structural.flyweight.forestgame;

public abstract class Tree {
    public int locationX;
    public int locationY;
    public int height;
    public String barkColor;
    public String specie;
    public String leafType;
    public String rootsType;

    public Tree(int locationX, int locationY, int height, String barkColor, String specie, String leafType, String rootsType) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.height = height;
        this.barkColor = barkColor;
        this.specie = specie;
        this.leafType = leafType;
        this.rootsType = rootsType;
    }

    public void render(){
        System.out.printf("Rendering tree on location: %d\n");
    }
}

package ge.edu.ug.patterns.structural.flyweight.storehouse;

public class Box {
    private static int instanceCount = 0;

    private final int width;
    private final int height;
    private final int depth;

    private final String material;
    private final String color;

    private final Integer id;

    public Box(int width, int height, int depth, String material, String color) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.material = material;
        this.color = color;
        this.id = BoxIdGenerator.getNextId();
        instanceCount++;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDepth() {
        return depth;
    }

    public String getMaterial() {
        return material;
    }

    public String getColor() {
        return color;
    }

    public Integer getId() {
        return id;
    }

    public static int getInstanceCount() {
        return instanceCount;
    }
}

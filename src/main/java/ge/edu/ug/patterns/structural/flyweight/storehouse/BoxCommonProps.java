package ge.edu.ug.patterns.structural.flyweight.storehouse;

public class BoxCommonProps {
    private static int instanceCount = 0;

    private final int width;
    private final int height;
    private final int depth;

    private final String material;
    private final String color;

    public BoxCommonProps(int width, int height, int depth, String material, String color) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.material = material;
        this.color = color;

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

    public static int getInstanceCount() {
        return instanceCount;
    }
}

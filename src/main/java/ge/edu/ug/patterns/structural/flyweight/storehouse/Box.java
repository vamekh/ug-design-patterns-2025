package ge.edu.ug.patterns.structural.flyweight.storehouse;

public class Box {
    private static int instanceCount = 0;

    private final BoxCommonProps commonProps;

    private final Integer id;

    public Box(BoxCommonProps commonProps) {
        this.commonProps = commonProps;
        this.id = BoxIdGenerator.getNextId();
        instanceCount++;
    }

    public String getColor() {
        return commonProps.getColor();
    }

    public BoxCommonProps getCommonProps() {
        return commonProps;
    }

    public Integer getId() {
        return id;
    }

    public static int getInstanceCount() {
        return instanceCount;
    }
}

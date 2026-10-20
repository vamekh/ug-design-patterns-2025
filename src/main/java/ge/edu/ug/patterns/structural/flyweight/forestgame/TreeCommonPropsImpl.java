package ge.edu.ug.patterns.structural.flyweight.forestgame;

// Concrete flyweight: immutable, so it is safe to share.
class TreeCommonPropsImpl implements TreeCommonProps {
    private final String barkColor;
    private final String species;
    private final String leafType;
    private final String rootsType;

    public TreeCommonPropsImpl(String barkColor, String species, String leafType, String rootsType) {
        this.barkColor = barkColor;
        this.species = species;
        this.leafType = leafType;
        this.rootsType = rootsType;
    }

    @Override
    public String getBarkColor() {
        return barkColor;
    }

    @Override
    public String getSpecies() {
        return species;
    }

    @Override
    public String getLeafType() {
        return leafType;
    }

    @Override
    public String getRootsType() {
        return rootsType;
    }
}

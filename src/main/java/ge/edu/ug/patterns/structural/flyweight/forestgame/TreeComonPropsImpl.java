package ge.edu.ug.patterns.structural.flyweight.forestgame;

class TreeComonPropsImpl implements TreeComonProps {
    protected final String barkColor;
    protected final String specie;
    protected final String leafType;
    protected final String rootsType;

    public TreeComonPropsImpl(String barkColor, String specie, String leafType, String rootsType) {
        this.barkColor = barkColor;
        this.specie = specie;
        this.leafType = leafType;
        this.rootsType = rootsType;
    }

    @Override
    public String getBarkColor() {
        return barkColor;
    }

    @Override
    public String getSpecie() {
        return specie;
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

package ge.edu.ug.patterns.structural.flyweight.forestgame;

// Flyweight: intrinsic state shared by all trees of one type.
public interface TreeCommonProps {
     String getBarkColor();
     String getSpecies();
     String getLeafType();
     String getRootsType();
}

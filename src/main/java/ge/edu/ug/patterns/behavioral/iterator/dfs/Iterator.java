package ge.edu.ug.patterns.behavioral.iterator.dfs;

public interface Iterator<T> {
    boolean hasNext();
    T next();
    void reset();
}

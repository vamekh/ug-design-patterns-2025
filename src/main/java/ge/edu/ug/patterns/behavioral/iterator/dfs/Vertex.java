package ge.edu.ug.patterns.behavioral.iterator.dfs;

import java.util.List;

public class Vertex <T> {
    public T value;
    public List<Vertex<T>> neighbours;

    public Vertex(T value) {
        this.value = value;
    }

    public void setNeighbours(List<Vertex<T>> neighbours) {
        this.neighbours = neighbours;
    }
}

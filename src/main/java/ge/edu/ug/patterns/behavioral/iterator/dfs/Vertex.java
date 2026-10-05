package ge.edu.ug.patterns.behavioral.iterator.dfs;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {
    // Public internals: every client walks the graph by poking at these fields.
    public T value;
    public List<Vertex<T>> neighbours = new ArrayList<>();

    public Vertex(T value) {
        this.value = value;
    }

    public void setNeighbours(List<Vertex<T>> neighbours) {
        this.neighbours = neighbours;
    }
}

package ge.edu.ug.patterns.behavioral.iterator.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Aggregate: the graph node keeps its structure private.
public class Vertex<T> {
    private final T value;
    private List<Vertex<T>> neighbours = new ArrayList<>();

    public Vertex(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public List<Vertex<T>> getNeighbours() {
        return Collections.unmodifiableList(neighbours);
    }

    public void setNeighbours(List<Vertex<T>> neighbours) {
        this.neighbours = neighbours;
    }
}

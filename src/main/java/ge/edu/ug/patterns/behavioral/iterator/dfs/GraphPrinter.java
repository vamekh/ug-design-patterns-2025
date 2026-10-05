package ge.edu.ug.patterns.behavioral.iterator.dfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

// PROBLEM: this client re-implements depth-first search with its own stack and visited set,
// reaching into Vertex.neighbours directly. RouteFinder contains the very same loop.
// Want breadth-first order instead? Rewrite the loop here AND in every other client.
public class GraphPrinter {

    public String print(Vertex<String> start) {
        StringJoiner out = new StringJoiner(" ");
        Deque<Vertex<String>> stack = new ArrayDeque<>();
        Set<Vertex<String>> visited = new HashSet<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            Vertex<String> current = stack.pop();
            if (visited.contains(current)) continue;
            visited.add(current);
            out.add(current.value);
            for (int i = current.neighbours.size() - 1; i >= 0; i--) {
                stack.push(current.neighbours.get(i));
            }
        }
        return out.toString();
    }
}

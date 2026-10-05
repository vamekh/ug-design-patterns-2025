package ge.edu.ug.patterns.behavioral.iterator.dfs;

import java.util.StringJoiner;

// Client: only knows "give me the values one by one", not how the graph is walked.
public class GraphPrinter {

    public String print(Iterable<String> traversal) {
        StringJoiner out = new StringJoiner(" ");
        for (String value : traversal) {
            out.add(value);
        }
        return out.toString();
    }
}

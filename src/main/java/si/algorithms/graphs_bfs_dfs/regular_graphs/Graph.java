package si.algorithms.graphs_bfs_dfs.regular_graphs;

import java.util.List;

public interface Graph<E> {
    void add(E value);
    boolean contains(E value);
    int size();
    void connectDirected(E a, E b);
    void connectUndirected(E a, E b);
    boolean connected(E a, E b);

    // Searching
    default boolean bfSearch(E start, E end) {
        throw new UnsupportedOperationException("BFS Not Implemented!");
    }
    default boolean dfSearch(E start, E end) {
        throw new UnsupportedOperationException("DFS Not Implemented!");
    }

    // Path Building
    default List<E> bfPath(E start, E end) {
        throw new UnsupportedOperationException("BFP Not Implemented!");
    }
    default List<E> dfPath(E start, E end) {
        throw new UnsupportedOperationException("DFP Not Implemented!");
    }
}
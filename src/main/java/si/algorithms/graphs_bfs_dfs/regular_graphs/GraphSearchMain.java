package si.algorithms.graphs_bfs_dfs.regular_graphs;

public class GraphSearchMain {
    public static void checkPath(Graph<String> graph, String a, String b){
        System.out.println("\"" + a + "\" to \"" + b + "\" has Path: " + graph.bfSearch(a, b));
    }
    
    public static void main(String[] args) {
        System.out.println();
        Graph<String> graph = new AdjacencyGraph<>();
        
        graph.add("A");
        graph.add("B");
        graph.add("C");
        graph.add("D");
        graph.add("E");
        graph.add("F");
        graph.add("G");
        graph.add("H");
        graph.add("I");
        graph.add("J");
        graph.add("K");
    
        graph.connectUndirected("A", "B");
        graph.connectDirected("A", "C");
        checkPath(graph, "A", "B");
        checkPath(graph, "B", "A");
        checkPath(graph, "A", "C");
        checkPath(graph, "C", "A");

        graph.connectUndirected("B", "E");
        checkPath(graph, "A", "E");

        graph.connectUndirected("C", "D");
        graph.connectUndirected("C", "E");
        graph.connectDirected("C", "H");
        checkPath(graph, "A", "H");
        checkPath(graph, "H", "A");
    }
    
}

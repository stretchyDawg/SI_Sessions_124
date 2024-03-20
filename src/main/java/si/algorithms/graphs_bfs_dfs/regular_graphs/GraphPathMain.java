package si.algorithms.graphs_bfs_dfs.regular_graphs;

public class GraphPathMain {
    public static void printPath(Graph<String> graph, String a, String b){
        System.out.println("Path from '" + a + "' to '" + b + "': " + graph.bfPath(a, b));
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
        graph.connectUndirected("B", "C");
        printPath(graph, "A", "C");
        printPath(graph, "C", "A");

        graph.connectDirected("A", "C");
        printPath(graph, "A", "C");
        printPath(graph, "C", "A");
        System.out.println();

        graph.connectUndirected("C", "D");
        graph.connectUndirected("D", "E");
        printPath(graph, "A", "E");
        graph.connectUndirected("B", "E");
        printPath(graph, "A", "E");
        System.out.println();

        graph.connectDirected("C", "H");
        printPath(graph, "H", "A");

        graph.connectUndirected("D", "F");
        graph.connectDirected("D", "B");
        graph.connectDirected("E", "F");
        graph.connectUndirected("F", "G");  
        printPath(graph, "A", "G");

        graph.connectUndirected("I", "K");
        graph.connectDirected("J", "I");
        graph.connectUndirected("J", "K");
    }
}

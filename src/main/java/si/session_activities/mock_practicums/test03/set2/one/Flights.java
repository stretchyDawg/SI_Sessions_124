package si.session_activities.mock_practicums.test03.set2.one;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import si.algorithms.graphs_bfs_dfs.regular_graphs.AdjacencyGraph;
import si.algorithms.graphs_bfs_dfs.regular_graphs.Graph;
import si.algorithms.graphs_bfs_dfs.weighted_graphs2024.WAdjacencyGraph;
import si.algorithms.graphs_bfs_dfs.weighted_graphs2024.WGraph;
import si.algorithms.graphs_bfs_dfs.weighted_graphs2024.WPath;


public class Flights {
    public static final String[] CITIES = {"Atlanta","Boston","Buffalo","Chicago",
                                    "Houston","Miami","Rochester","San Diego",
                                    "Seattle","Topeka"};
    public static final Graph<String> GRAPH = makeGraph();
    public static final WGraph<String> WGRAPH = makeWGraph();

    public static Map<String,Integer> getFewestLayovers() {
        Map<String,Integer> fewestLayovers = new TreeMap<>();

        List<String> citiesList= Arrays.asList(CITIES);

        for (int i = 0; i < citiesList.size(); i++){
            for (int j = 0; j < citiesList.size(); j++){
                // Cant travel from Boston to Boston
                if (i != j){
                    if (!(fewestLayovers.containsKey(citiesList.get(i)+ ":"+ citiesList.get(j)))){
                        List<String> a = GRAPH.bfPath(citiesList.get(i),citiesList.get(j));
                        if (a != null){
                            fewestLayovers.put(citiesList.get(i)+ ":"+ citiesList.get(j), a.size()-2);
                        }
                    }
                }
            }
        }
        return fewestLayovers;
    }

    public static Map<String,Integer> getLowestCosts() {
        Map<String,Integer> lowestCosts = new TreeMap<>();

        List<String> citiesList = Arrays.asList(CITIES);

        for (int i = 0; i < citiesList.size(); i++){
            for (int j = 0; j < citiesList.size(); j++){
                if (i != j){
                    if (!(lowestCosts.containsKey(citiesList.get(i)+ ":"+ citiesList.get(j)))){
                        WPath<String> a = WGRAPH.dijkstrasPath(citiesList.get(i), citiesList.get(j));
                        if (a != null){
                            lowestCosts.put(citiesList.get(i)+ ":"+ citiesList.get(j), (int)a.getDistance());
                        }
                    }
                }
            }
        }

        return lowestCosts;
    }

    public static void main(String[] args) {
        System.out.println("Fewest Layovers");
        Map<String,Integer> fewestLayovers = getFewestLayovers();
        for (String cities : fewestLayovers.keySet()) {
            System.out.println(cities + " " + fewestLayovers.get(cities));
        }

        System.out.println("\nLowest Cost");
        Map<String,Integer> lowestCosts = getLowestCosts();
        for (String cities : fewestLayovers.keySet()) {
            System.out.println(cities + " " + lowestCosts.get(cities));
        }
    }

    /*
     * Helper methods below, do not alter
     */
    public static Graph<String> makeGraph() {
        Graph<String> graph = new AdjacencyGraph<>();

        for (int i = 0;i < CITIES.length;++i)
            graph.add(CITIES[i]);

            graph.connectUndirected("Atlanta","Buffalo");
            graph.connectUndirected("Atlanta","Houston");
            graph.connectUndirected("Atlanta","Miami");
    
            graph.connectUndirected("Boston","Miami");
            graph.connectUndirected("Boston","Rochester");
            graph.connectUndirected("Boston","Seattle");
    
            graph.connectUndirected("Buffalo","Chicago");
            graph.connectUndirected("Buffalo","Rochester");
    
            graph.connectUndirected("Chicago","Boston");
            graph.connectUndirected("Chicago","Houston");
            graph.connectUndirected("Chicago","Seattle");
    
            graph.connectUndirected("Houston","Topeka");
    
            graph.connectUndirected("Miami","San Diego");
    
            graph.connectUndirected("San Diego","Seattle");
            graph.connectUndirected("San Diego","Topeka");

        return graph;
    }

    public static WGraph<String> makeWGraph() {
        WGraph<String> wgraph = new WAdjacencyGraph<>();

        for (int i = 0;i < CITIES.length;++i)
            wgraph.add(CITIES[i]);

        wgraph.connect("Atlanta","Buffalo",178);
        wgraph.connect("Atlanta","Houston",429);
        wgraph.connect("Atlanta","Miami",99);

        wgraph.connect("Boston","Miami",699);
        wgraph.connect("Boston","Rochester",200);
        wgraph.connect("Boston","Seattle",1045);

        wgraph.connect("Buffalo","Chicago",275);
        wgraph.connect("Buffalo","Rochester",72);

        wgraph.connect("Chicago","Boston",550);
        wgraph.connect("Chicago","Houston",237);
        wgraph.connect("Chicago","Seattle",321);

        wgraph.connect("Houston","Topeka",365);

        wgraph.connect("Miami","San Diego",713);

        wgraph.connect("San Diego","Seattle",275);
        wgraph.connect("San Diego","Topeka",472);

        return wgraph;
    }
}
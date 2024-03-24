package si.algorithms.backtracker.best_graph_path;

import java.util.ArrayList;
import java.util.List;

import si.algorithms.graphs_bfs_dfs.weighted_graphs2024.WAdjacencyGraph;

public class GraphConfigMain {
    public static WAdjacencyGraph<Character> graphOne(){
        WAdjacencyGraph<Character> graph = new WAdjacencyGraph<>();
        graph.add('A');
        graph.add('B');
        graph.add('C');
        graph.add('D');
        graph.add('E');

        graph.connect('A', 'B', 1);
        graph.connect('A','D', 5);
        graph.connect('A','C', 3);
        graph.connect('B', 'D', 7);
        graph.connect('C','E', 4);
        graph.connect('D','E',5);

        return graph;
    }
    
    //standard solve method
    public static List<GraphConfig> solve(GraphConfig config, ArrayList<GraphConfig> configs) {
        if(configs == null){
            configs = new ArrayList<>();
        }
        
        if (config.isGoal()) {
            configs.add(config);
        } 
        else {
            for (GraphConfig child : config.getSuccessors()) {
                if (child.isValid()) {
                    solve(child, configs);
                }
            }
        }
        return configs;
    }

    public static void main(String[] args) {
        System.out.println();
        WAdjacencyGraph<Character> graphOne = graphOne();

        List<GraphConfig> configsAE = solve(new GraphConfig(graphOne, 'A', 'E'), null);
        int count = 1;
        for(GraphConfig config : configsAE){
            System.out.println("Config " + count + ": " + config.getPath());
            count++;
        }

        System.out.println();

        List<GraphConfig> configsBE = solve(new GraphConfig(graphOne, 'B', 'E'), null);
        count = 1;
        for(GraphConfig config : configsBE){
            System.out.println("Config " + count + ": " + config.getPath());
            count++;
        }
    }
}
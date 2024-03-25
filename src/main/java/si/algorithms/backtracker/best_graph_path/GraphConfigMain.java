package si.algorithms.backtracker.best_graph_path;

import java.util.ArrayList;
import java.util.List;

import si.algorithms.graphs_bfs_dfs.weighted_graphs2024.WAdjacencyGraph;

public class GraphConfigMain {
    public static WAdjacencyGraph<Character> graphTwo(){
        // The fact that is is a weighted graph means nothing.
        WAdjacencyGraph<Character> graph = new WAdjacencyGraph<>();
        graph.add('A');
        graph.add('B');
        graph.add('C');
        graph.add('D');
        graph.add('E');
        graph.add('F');
        graph.add('G');
        graph.add('H');
        graph.add('I');
        graph.add('J');

        // Really complicated graph
        graph.connect('A', 'G', 1);
        graph.connect('A', 'H', 5);
        graph.connect('A', 'I', 3);
        graph.connect('A', 'B', 1);
        graph.connect('A', 'C', 5);
        graph.connect('B', 'F', 3);
        graph.connect('B', 'J', 7);
        graph.connect('B', 'A', 4);
        graph.connect('C', 'B', 5);
        graph.connect('C', 'A', 5);
        graph.connect('D', 'E', 5);
        graph.connect('D', 'B', 3);
        graph.connect('D', 'I', 1);
        graph.connect('D', 'C', 5);
        graph.connect('D', 'J', 3);
        graph.connect('D', 'F', 7);
        graph.connect('E', 'A', 4);
        graph.connect('E', 'B', 5);
        graph.connect('E', 'I', 5);
        graph.connect('F', 'I', 3);
        graph.connect('F', 'J', 7);
        graph.connect('G', 'A', 4);
        graph.connect('G', 'J', 5);
        graph.connect('H', 'I', 1);
        graph.connect('H', 'C', 5);
        graph.connect('H', 'J', 3);
        graph.connect('I', 'F', 7);
        graph.connect('I', 'A', 3);
        graph.connect('I', 'F', 1);
        graph.connect('J', 'C', 5);
        graph.connect('J', 'F', 3);
        graph.connect('J', 'I', 7);
        return graph;
    }

    public static WAdjacencyGraph<Character> graphOne(){
        WAdjacencyGraph<Character> graph = new WAdjacencyGraph<>();
        graph.add('A');
        graph.add('B');
        graph.add('C');
        graph.add('D');
        graph.add('E');

        graph.connect('A', 'B', 1);
        graph.connect('A', 'D', 5);
        graph.connect('A', 'C', 3);
        graph.connect('B', 'D', 7);
        graph.connect('C', 'E', 4);
        graph.connect('D', 'E', 5);

        return graph;
    }
    
    // solve method 
    // this method is given to you here, and will (most likely, dont quote me) be given to you on tests and homework.
    public static List<GraphConfig> solve(GraphConfig config, ArrayList<GraphConfig> configs) {
        if(configs == null){
            configs = new ArrayList<>();
        }
        
        if(config.isGoal()) {
            configs.add(config);
        } 
        else {
            for(GraphConfig child : config.getSuccessors()) {
                if (child.isValid()) {
                    solve(child, configs);
                }
            }
        }
        return configs;
    }

    // How to use Backtracker (simply just call the solve method they give you)
    //
    // In GCIS-124, you will either have to use the solve() method in the main method OR they will give you a JUnit test to solve.
    public static void main(String[] args) {
        System.out.println();

        WAdjacencyGraph<Character> graphOne = graphOne();
        List<GraphConfig> configsAtoE = solve(new GraphConfig(graphOne, 'A', 'E'), null); // <-- Use the solve method (in this case it is static)
        int count = 1;
        for(GraphConfig config : configsAtoE){
            System.out.println("Config " + count + ": " + config.getPath());
            count++;
        }
        System.out.println();
        List<GraphConfig> configsBtoE = solve(new GraphConfig(graphOne, 'B', 'E'), null);
        count = 1;
        for(GraphConfig config : configsBtoE){
            System.out.println("Config " + count + ": " + config.getPath());
            count++;
        }


        WAdjacencyGraph<Character> graphTwo = graphTwo();
        System.out.println();
        List<GraphConfig> configsAtoI = solve(new GraphConfig(graphTwo, 'A', 'I'), null);
        count = 1;
        for(GraphConfig config : configsAtoI){
            System.out.println("Config " + count + ": " + config.getPath());
            count++;
        }
    }
}
package si.algorithms.backtracker.best_graph_path;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import si.algorithms.backtracker.Configuration;
import si.algorithms.graphs_bfs_dfs.weighted_graphs2024.WAdjacencyGraph;
import si.algorithms.graphs_bfs_dfs.weighted_graphs2024.Edge;

public class GraphConfig implements Configuration<GraphConfig> {
    private ArrayList<Character> path; //path which is specific to each config
    private Character end;
    private WAdjacencyGraph<Character> weightedGraph; //graph

    // Constructor for initial state / initial configuration
    public GraphConfig(WAdjacencyGraph<Character> weightedGraph, Character start, Character end) {
        this.weightedGraph = weightedGraph;
        this.end = end;
        this.path = new ArrayList<>();
        this.path.add(start);
    }

    // Constructor for successor states / successor configurations
    // This method is used in getSuccessors(). 
    // You will (most likely) have to make a second constructor for successors when making getSuccessors() on homeworks or tests.
    private GraphConfig(WAdjacencyGraph<Character> weightedGraph, ArrayList<Character> parentPath, Character newChar, Character endChar) {
        this.weightedGraph = weightedGraph;
        this.end = endChar;
        
        path = new ArrayList<>(parentPath);
        path.add(newChar);
    }

    // simple getter, used for printing every path
    public ArrayList<Character> getPath() {
        return path;
    }

    @Override
    public Collection<GraphConfig> getSuccessors() {
        ArrayList<GraphConfig> successors = new ArrayList<>();

        for (Edge<Character> e : weightedGraph.getVertex(path.get(path.size()-1)).edges()) { // <--- gets the most recently added character to the path and finds its edges
            Character newCharacter = e.getTo().getValue();
            GraphConfig newGraphConfig = new GraphConfig(weightedGraph, path, newCharacter, end);

            successors.add(newGraphConfig);
        }

        return successors;
    }

    // isValid():
    // - Makes sure that a state is valid or not (invalid would be tic-tac-toe board with 2 X's or 2 O's, etc...)
    // - In the graphConfig context, it's making sure that there are no duplicate points in the path
    // 
    // There are two ways to achieve this:
    // - You can use the ArrayList .contains() method (less lines of code)
    // - You can make a Set.
    // They both have the same time complexity (the ArrayList .contains() method uses Sets and takes the same amount of time)

    // Less lines of code
    // @Override
    // public boolean isValid() {
    //     Character pathSymbol = path.remove(path.size() - 1);
    //     if(path.contains(pathSymbol)){
    //         return false;
    //     }
    //     path.add(pathSymbol);
    //     return true;
    // }

    // More lines of code (does the same thing, same time complexity, etc...)
    @Override
    public boolean isValid(){
        Set<Character> discoveredPathSymbols = new HashSet<>();

        for(Character pathSymbol : path){
            if(discoveredPathSymbols.contains(pathSymbol)){
                return false;
            }
            else{
                discoveredPathSymbols.add(pathSymbol);
            }
        }
        return true;
    }

    // Checks if last vertex is the end vertex.
    // You can also check both the start and the end vertex, but this also gets the job done.
    @Override
    public boolean isGoal() {
        return path.get(path.size() - 1) == end;
    }
}
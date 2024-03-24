package si.algorithms.backtracker.best_graph_path;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import si.algorithms.backtracker.Configuration;
import si.algorithms.graphs_bfs_dfs.weighted_graphs2024.WAdjacencyGraph;
import si.algorithms.graphs_bfs_dfs.weighted_graphs2024.WVertex;
import si.algorithms.graphs_bfs_dfs.weighted_graphs2024.Edge;

public class GraphConfig implements Configuration<GraphConfig> {
    private ArrayList<Character> path; //path which is specific to each config
    private Character end;
    private WAdjacencyGraph<Character> weightedGraph; //graph

    public GraphConfig(WAdjacencyGraph<Character> weightedGraph, Character start, Character end) {
        this.weightedGraph = weightedGraph;
        this.end = end;
        this.path = new ArrayList<>();
        this.path.add(start);
    }

    private GraphConfig(WAdjacencyGraph<Character> weightedGraph, ArrayList<Character> parentPath, Character newChar, Character endChar) {
        this.weightedGraph = weightedGraph;
        this.end = endChar;
        
        path = new ArrayList<>(parentPath);
        path.add(newChar);
    }

    public ArrayList<Character> getPath() {
        return path;
    }

    @Override
    public Collection<GraphConfig> getSuccessors() {
        ArrayList<GraphConfig> successors = new ArrayList<>();

        WVertex<Character> mostRecentVertex = weightedGraph.getVertex(path.get(path.size()-1));
        Set<Edge<Character>> vertexEdges = mostRecentVertex.edges();
        
        for (Edge<Character> e : vertexEdges) { 
            Character newCharacter = e.getTo().getValue();
            GraphConfig newGraphConfig = new GraphConfig(weightedGraph, path, newCharacter, newCharacter);

            successors.add(newGraphConfig);
        }

        return successors;
    }

    //makes sure that there are no duplicate points in the path
    @Override
    public boolean isValid() {
        Character character = path.remove(path.size() - 1);
        if(path.contains(character)){
            return false;
        }
        path.add(character);
        return true;
    }

    //checks if last vertex is the end vertex
    @Override
    public boolean isGoal() {
        return path.get(path.size() - 1) == end;
    }
}
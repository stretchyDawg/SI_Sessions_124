package si.algorithms.graphs.regular_graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AdjacencyGraph<E> implements Graph<E> {

    private Map<E, Vertex<E>> vertices;
    
    public AdjacencyGraph() {
        vertices = new HashMap<>();
    }

    @Override
    public void add(E value) {
        Vertex<E> vertex = new Vertex<>(value);
        vertices.put(value, vertex);

    }

    @Override
    public boolean contains(E value) {
        return vertices.containsKey(value);
    }

    @Override
    public int size() {
        return vertices.size();
    }

    @Override
    public void connectDirected(E a, E b) {
        Vertex<E> vertexA = vertices.get(a);
        Vertex<E> vertexB = vertices.get(b);
        vertexA.connect(vertexB);
    }

    @Override
    public void connectUndirected(E a, E b) {
        Vertex<E> vertexA = vertices.get(a);
        Vertex<E> vertexB = vertices.get(b);
        vertexA.connect(vertexB);
        vertexB.connect(vertexA);
    }

    @Override
    public boolean connected(E a, E b) {
        Vertex<E> vertexA = vertices.get(a);
        Vertex<E> vertexB = vertices.get(b);
        return vertexA.connected(vertexB);
    }


    /*
     * Search = Checking if a path exists between one end to another.
     * 
     * Get start and end vertices from map.
     * 
     * Create a queue of vertices you will check using a linked list.
     * Create a set of visited vertices.
     * Add start vertex to queue and set.
     * 
     * Dequeue front, if it equals the end, return true.
     * If it doesn't, add all of that vertex's neighbors to set and queue.
     * Check to see if the neighbors are the end until queue is empty.
     * 
     * If never true, return false.
     */
    @Override
    public boolean bfSearch(E start, E end) {
        Vertex<E> startVertex = vertices.get(start);
        Vertex<E> endVertex = vertices.get(end);

        Queue<Vertex<E>> queue = new LinkedList<>();
        Set<Vertex<E>> visited = new HashSet<>();

        queue.add(startVertex);
        visited.add(startVertex);

        while(!queue.isEmpty()) {
            Vertex<E> enqueuedVertex = queue.poll();
            if(enqueuedVertex == endVertex) {
                return true;
            } 
            else {
                for(Vertex<E> neighborVertex : enqueuedVertex.getNeighbors()) {
                    if(!visited.contains(neighborVertex)) {
                        visited.add(neighborVertex);
                        queue.add(neighborVertex);
                    }
                }
            }
        }

        return false;
    }

    /*
     * Do the same except make a map to have unique keys but nonunique values.
     */
    @Override
    public List<E> bfPath(E start, E end) {
        Vertex<E> startVertex = vertices.get(start);
        Vertex<E> endVertex = vertices.get(end);

        Queue<Vertex<E>> queue = new LinkedList<>();
        Map<Vertex<E>, Vertex<E>> predecessors = new HashMap<>();
        // Key = Vertex  <---->  Value = Where it came from

        queue.add(startVertex);
        predecessors.put(startVertex, null);

        while(!queue.isEmpty()) {
            Vertex<E> enqueuedVertex = queue.poll();
            if(enqueuedVertex == endVertex) {
                break; // Found path.
            } 
            else {
                for(Vertex<E> neighborVertex : enqueuedVertex.getNeighbors()) {
                    if(!predecessors.containsKey(neighborVertex)) {
                        predecessors.put(neighborVertex, enqueuedVertex);
                        queue.add(neighborVertex);
                    }
                }
            }
        }

        return makePath(predecessors, endVertex);
    }

    private List<E> makePath(Map<Vertex<E>, Vertex<E>> predecessors, Vertex<E> endVertex) {
        if(predecessors.containsKey(endVertex)) {
            List<E> path = new LinkedList<>();
            Vertex<E> current = endVertex;
            
            // Start from the end:
            // - Add value to the start of the list 
            // - Shift everything to the right after that.
            // - Get the next predecessor until it is null (start is the ony one associated with null)
            while(current != null) {
                path.add(0, current.getValue());
                current = predecessors.get(current);
            }

            return path;
        } 
        else {
            return null; // If the end isn't there, don't even make a path.
        }
    }

    @Override
    public boolean dfSearch(E start, E end) {
        Vertex<E> s = vertices.get(start);
        Vertex<E> e = vertices.get(end);

        Set<Vertex<E>> visited = new HashSet<>();
        visited.add(s);

        visitDFS(s, visited);

        return visited.contains(e);
    }

    @Override
    public List<E> dfPath(E start, E end) {
        Vertex<E> s = vertices.get(start);
        Vertex<E> e = vertices.get(end);

        Set<Vertex<E>> visited = new HashSet<>();
        visited.add(s);

        return visitDFPath(s, e, visited);
    }

    private void visitDFS(Vertex<E> vertex, Set<Vertex<E>> visited) {
        for(Vertex<E> neighbor : vertex.getNeighbors()) {
            if(!visited.contains(neighbor)) {
                visited.add(neighbor);
                visitDFS(neighbor, visited);
            }
        }
    }

    private List<E> visitDFPath(Vertex<E> v, Vertex<E> e, 
        Set<Vertex<E>> visited) {
        if(v == e) {
            List<E> path = new LinkedList<>();
            path.add(e.getValue());
            return path;
        } else {
            for(Vertex<E> neighbor : v.getNeighbors()) {
                if(!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    List<E> path = visitDFPath(neighbor, e, visited);
                    if(path != null) {
                        path.add(0, v.getValue());
                        return path;
                    }
                }
            }
            return null;
        }
    }
}

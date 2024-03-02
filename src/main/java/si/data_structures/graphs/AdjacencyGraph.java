package si.data_structures.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import si.data_structures.Vertex;

public class AdjacencyGraph<E> implements Graph<E>{
    private Map<E, Vertex<E>> vertices;

    public AdjacencyGraph(){
        this.vertices = new HashMap<>();
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

    @Override
    public boolean bfSearch(E start, E end){
        Vertex<E> startVertex = vertices.get(start);
        Vertex<E> endVertex = vertices.get(end);

        Queue<Vertex<E>> queue = new LinkedList<>();
        Set<Vertex<E>> visited = new HashSet<>();

        queue.add(startVertex);
        visited.add(startVertex);

        while(!queue.isEmpty()){
            Vertex<E> vertex = queue.poll(); //dequeues head of queue
            if(vertex == endVertex){
                return true;
            }
            else{
                for(Vertex<E> n : vertex.getNeighbors()){
                    if(!visited.contains(n)){
                        visited.add(n);
                        queue.add(n);
                    }
                }
            }
        }
        return false;
    }

    private List<E> makePath(Map<Vertex<E>, Vertex<E>> predecessors, Vertex<E> end){
        if(predecessors.containsKey(end)){
            List<E> path = new LinkedList<>();
            Vertex<E> current = end;
            while(current != null){
                path.add(0, current.getValue());
                current = predecessors.get(current);
            }
            return path;
        }
        else{
            return null;
        }
    }

    @Override
    public List<E> bfPath(E start, E end){
        Vertex<E> startVertex = vertices.get(start);
        Vertex<E> endVertex = vertices.get(end);

        Queue<Vertex<E>> queue = new LinkedList<>();
        Map<Vertex<E>, Vertex<E>> predecessors = new HashMap<>();

        queue.add(startVertex);
        predecessors.put(startVertex, null);

        while(!queue.isEmpty()){
            Vertex<E> vertex = queue.poll();
            if(vertex == endVertex){
                break;
            }
            else{
                for(Vertex<E> n : vertex.getNeighbors()){
                    if(!predecessors.containsKey(n)){
                        predecessors.put(n, vertex);
                        queue.add(n);
                    }
                }
            }
        }

        return makePath(predecessors, endVertex);
    }

    private void visitDFS(Vertex<E> vertex, Set<Vertex<E>> visited){
        for(Vertex<E> neighbor : vertex.getNeighbors()){
            if(!visited.contains(neighbor)){
                visited.add(neighbor);
                visitDFS(neighbor, visited);
            }
        }
    }

    @Override
    public boolean dfSearch(E start, E end){
        Vertex<E> startVertex = vertices.get(start);
        Vertex<E> endVertex = vertices.get(end);

        Set<Vertex<E>> visited = new HashSet<>();
        visited.add(startVertex);
        
        visitDFS(startVertex, visited);
        return visited.contains(endVertex);
    }
    
    private List<E> visitDFPath(Vertex<E> v, Vertex<E> e, Set<Vertex<E>> visited){
        if(v == e){
            List<E> path = new LinkedList<>();
            path.add(e.getValue());
            return path;
        }

        else{

            for(Vertex<E> neighbor : v.getNeighbors()){

                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    List<E> path = visitDFPath(neighbor, e, visited);
                    if(path != null){
                        path.add(0, v.getValue());
                        return path;
                    }
                }
            }
            return null;
        }
    }

    @Override
    public List<E> dfPath(E start, E end){
        Vertex<E> startVertex = vertices.get(start);
        Vertex<E> endVertex = vertices.get(end);

        Set<Vertex<E>> visited = new HashSet<>();
        visited.add(startVertex);

        return visitDFPath(startVertex, endVertex, visited);
    }
}

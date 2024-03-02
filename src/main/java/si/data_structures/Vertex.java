package si.data_structures;
import java.util.HashSet;
import java.util.Set;

public class Vertex<E> {
    private E value;
    private Set<Vertex<E>> neighbors; 

    // Constructors:
    public Vertex(E value){
        this.value = value;
        this.neighbors = new HashSet<>();
    }

    // Getters / Setters:
    public E getValue(){
        return this.value;
    }
    public Set<Vertex<E>> getNeighbors(){
        return this.neighbors;
    }

    // Methods:
    public void connect(Vertex<E> neighbor){
        this.neighbors.add(neighbor);
    }

    public boolean connected(Vertex<E> neighbor){
        return this.neighbors.contains(neighbor);
    }   
}

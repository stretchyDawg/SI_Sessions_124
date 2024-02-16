package si.data_structures.queues;
import java.util.Iterator;
import java.util.NoSuchElementException;

import si.data_structures.Node;
import si.data_structures.NodeIterator;

public class NodeQueue<E> implements Queue<E>{
    private Node<E> front;
    private Node<E> back;
    private int size;

    public NodeQueue(){
        front = null;
        back = null;
        size = 0;
    }

    public E getFront(){
        return this.front.getValue();
    }

    @Override
    public void enqueue(E value) {
        Node<E> n = new Node<>(value);
        if(front == null){
            front = n;
            back = n;
        }
        else{
            back.setNext(n);
            back = n;
        }
        ++size;

    }
    @Override
    public E dequeue() {
        if(size == 0){
            throw new NoSuchElementException("Queue is empty");

        }
        E value = front.getValue();
        front = front.getNext();
        if(front == null){
            back = null;
        }
        --size;
        return value;

    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString(){
        return size + ", " + front;
    }

    @Override 
    public Iterator<E> iterator(){
        return new NodeIterator<E>(front);
    }

}

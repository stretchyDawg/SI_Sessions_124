package si.data_structures.stacks;

import java.util.Iterator;

import si.data_structures.Node;
import si.data_structures.NodeIterator;

public class NodeStack<E> implements Stack<E> {
    private Node<E> top;
    private int size;
    
    public NodeStack(E value){
        this.push(value);
    }
    
    public Iterator<E> iterator(){
        return new NodeIterator<E>(this.top);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public E top() {
        E value = this.top.getValue();
        return value;
    }

    @Override
    public void push(E value) {
        this.size++;
        Node<E> node = new Node<E>(value);
        if(this.top != null){
            node.setNext(this.top);
        }
        else{
            node.setNext(null);
        }
        this.top = node;
    }

    @Override
    public E pop() {
        this.size--;
        if(this.size <= 0){
            this.size = 0;
            if(this.top != null){
                E value = this.top.getValue();
                this.top = null;
                return value;
            }
            else{
                return null;
            }
        }
        else if(size > 0){
            E value = this.top.getValue();
            Node<E> next = this.top.getNext();
            this.top = next;
            return value; 
        }
        return null;
    }
    

    public String toString(){
        if(this.top != null){
            return "Stack: " + this.top.toString() + 
                   "\nSize: " + this.size + "\n";
        }
        else{
            return "Stack: null" + 
                   "\nSize: " + this.size + "\n";
        }
    }
}

package si.data_structures.queues;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import si.data_structures.ArrayIterator;

public class ArrayQueue<E> implements Queue<E>{
    
    private static final int INIT_CAPACITY = 4;
    private int size;
    private int front;
    private int back;
    private E[] elements;

    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        this.size = 0;
        this.front = 0;
        this.back = 0;
        this.elements = (E[])new Object[INIT_CAPACITY];
    }

    @Override
    public int size() { return size; }

    private int circularIncrement(int index){
        return (index+1) % elements.length;
    }
    
    @SuppressWarnings("unchecked")
    private void resize(){
        E[] newElements = (E[])new Object[elements.length*2];
        for(int i = 0; i < size + 1; i++){
            newElements[i] = elements[front];
            front = circularIncrement(front);
        }
        this.front = 0;
        this.back = size;
        this.elements = newElements;
    }

    @Override
    public void enqueue(E value) {
        if(size == elements.length){
            resize();
        }
        elements[back] = value;
        back = circularIncrement(back);
        ++size;
    }

    @Override
    public E dequeue() {
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        
        E value = elements[front];
        elements[front] = null;
        front = circularIncrement(front);
        size--;

        return value;
    }

    @Override
    public Iterator<E> iterator(){
        return new ArrayIterator<E>(elements, size);
    }

    @Override
    public String toString() {
        return size + ", " + Arrays.toString(elements);
    }

    public static void main(String[] args) {

    }

}

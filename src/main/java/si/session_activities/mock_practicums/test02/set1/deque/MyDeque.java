package si.session_activities.mock_practicums.test02.set1.deque;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyDeque<E> implements Deque<E>{
    private Node<E> front;
    private Node<E> back;
    private int size;


    //Constructors
    public MyDeque(){
        this.front = null;
        this.back = null;
        this.size = 0;
    }

    //Override Methods
    @Override
    public void enqueueFront(E element) {
        Node<E> n = new Node<>(element);
        if(this.front == null){
            this.front = n;
            this.back = n;
        }
        else{
            n.setNext(this.front);
            this.front = n;
        }
        this.size++;
    }

    @Override
    public void enqueueBack(E element) {
        Node<E> n = new Node<>(element);
        if(this.front == null){
            this.front = n;
            this.back = n;
        }
        else{
            this.back.setNext(n);
            this.back = n;
        }
        this.size++;
    }

    @Override
    public E dequeueFront() {
        if(this.size == 0){
            throw new NoSuchElementException("Not enough elements.");
        }
        E value = front.getValue();
        front = front.getNext();
        if(front == null){
            back = null;
        }
        
        this.size--;
        return value;
    }

    @Override
    public E dequeueBack() {
        if(this.size == 0){
            throw new NoSuchElementException("Not enough elements.");
        }

        E value = back.getValue();        
        Node<E> temp = this.front;
        while(temp.getNext() != this.back && temp.getNext() != null){
            temp = temp.getNext();
        }
        this.back = temp;
        
        this.size--;
        return value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator(){
        return new NodeIterator<>(front);
    }
}

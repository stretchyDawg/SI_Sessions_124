package si.data_structures.lists;

import java.util.Iterator;

import si.data_structures.Node;
import si.data_structures.NodeIterator;

public class LinkedList<E> implements List<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public LinkedList(List<E> list){
        this.size = 0;

        for(int i = 0; i < list.size(); i++){
            E value = list.get(i);
            this.append(value);
        }
    } 

    @Override
    public void append(E value) {
        Node<E> node = new Node<E>(value);
        if (this.size == 0){
            this.head = node;
            this.tail = node;
        }
        else{
            this.tail.setNext(node);
            this.tail = node;
        }
        this.size++;
    }

    @Override
    public E get(int index) {
        if(index > this.size){
            throw new IndexOutOfBoundsException();
        }
        
        try{
            int counter = 0;
            Node<E> out = this.head;
            while(counter != index){
                out = out.getNext();
                counter++;
            }
            return out.getValue();
        }
        catch(NullPointerException n){
            throw new IndexOutOfBoundsException();

        }
    }

    @Override
    public void set(int index, E value) {
        if(index > this.size){
            throw new IndexOutOfBoundsException();
        }
        
        int counter = 0;
        Node<E> node = this.head;
        while(counter != index){
            node = node.getNext();
            counter++;
        }
        node.setValue(value);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString(){
        return size + ", " + this.head;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Iterator<E> iterator(){
        return new NodeIterator(head);
    }

    @Override @SuppressWarnings("unchecked")
    public boolean equals(Object obj){
        if(obj instanceof LinkedList){
            LinkedList<E> other = (LinkedList<E>)(obj);
            for(int i = 0; i < this.size(); i++){
                if(this.get(i) != other.get(i)){
                    return false;
                }
            }
            return (this.size() == other.size());
        }
        return false;
    }

    public static void main(String[] args){
        LinkedList<Double> list = new LinkedList<>();
        
        list.append(5.0);
        System.out.println(list); 

        list.append(2.0);
        list.append(3.0);
        System.out.println(list);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        //System.out.println(list.get(3));

        LinkedList<Double> list2 = new LinkedList<>(list);
        System.out.println(list2);
        System.out.println(list.equals(list2));
        list2.append(7.23487264);
        System.out.println(list.equals(list2));

    }
}

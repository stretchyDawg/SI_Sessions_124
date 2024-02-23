package si.data_structures.lists;

import java.util.Arrays;
import java.util.Iterator;

import si.data_structures.ArrayIterator;

public class ArrayList<E> implements List<E>{
    private static final int INIT_CAPACITY = 4;
    private Object[] elements;
    private int size;

    public ArrayList(){
        this.size = 0;
        this.elements = new Object[INIT_CAPACITY];
    }

    public ArrayList(List<E> list){
        this.size = 0;
        this.elements = new Object[INIT_CAPACITY];

        for(int i = 0; i < list.size(); i++){
            E value = list.get(i);
            this.append(value);
        }
    }

    @Override
    public void append(E value) {
        if(size == elements.length){
            elements = Arrays.copyOf(elements, elements.length*2);
        }
        elements[size] = value;
        size++;
    }

    @Override @SuppressWarnings("unchecked")
    public E get(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return (E)elements[index];
    }

    @Override
    public void set(int index, E value) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Invalid index");
        }
        
        elements[index] = value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator(){
        return new ArrayIterator<E>(elements, size);
    }

    @Override
    public String toString(){
        return size + ", " + Arrays.toString(this.elements);
    }

    @Override @SuppressWarnings("unchecked")
    public boolean equals(Object obj){
        if(obj instanceof ArrayList){
            ArrayList<E> other = (ArrayList<E>)(obj);

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
        List<Double> list = new ArrayList<>();
        list.append(-100.1);
        list.append(200.2);
        System.out.println(list);

        list.append(-300.3);
        list.append(400.4);
        System.out.println(list);

        list.append(-500.5);
        System.out.println(list);

        list.set(3, 999.9);
        System.out.println(list);

        List<Double> list2 = new ArrayList<>(list);
        System.out.println(list2);

        List<String> list3 = new ArrayList<>();
        list3.append("a");
        list3.append("a");
        list3.append("a");

        List<String> list4 = new ArrayList<>(list3);
        list4.append("a");
        
        System.out.println(list.equals(list2));
        System.out.println(list2.equals(list3));
    } 
}

package si.data_structures.stacks;

import java.util.Arrays;

import si.data_structures.ArrayIterator;




public class ArrayStack<E> implements Stack<E> {
    private static final int INIT_CAPACITY = 4;
    private Object[] elements;
    private int size;
    private E top;

    public ArrayStack(){
        this.size = 0;
        this.elements = new Object[INIT_CAPACITY];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public E top() {
        return this.top;
    }

    @Override 
    public void push(E value) {
        if(size == elements.length){
            this.elements = Arrays.copyOf(elements, elements.length*2);
        }
        elements[size] = value;
        this.top = value;
        size++;
    }

    @Override @SuppressWarnings("unchecked")
    public E pop() {
        E value = (E)elements[size];
        elements[size] = null;
        size--;
        if(this.size != 0){
            this.top = (E)elements[size-1];
        }
        else{
            this.top = null;
        }
    
        return value;
    }

    public ArrayIterator<E> iterator(){
        return new ArrayIterator<E>(elements, size);
    }

    public String toString(){
        String str = "[";
        for(int i = 0; i < this.size; i++){
            str += this.elements[i];
            if(i != this.size-1){
                str += ", ";
            }
        }
        return str + "]";
    }



    public static void main(String[] args){
        ArrayStack<Double> doubleStack = new ArrayStack<Double>();
        
        System.out.println("\nArrayStack:\n" + doubleStack.size() + " | " + doubleStack + " | " + doubleStack.top());
        doubleStack.push(1.0);
        System.out.println(doubleStack.size() + " | " + doubleStack + " | " + doubleStack.top());
        doubleStack.push(2.0);
        System.out.println(doubleStack.size() + " | " + doubleStack + " | " + doubleStack.top());
        doubleStack.push(3.0);
        System.out.println(doubleStack.size() + " | " + doubleStack + " | " + doubleStack.top());
        doubleStack.push(4.0);
        System.out.println(doubleStack.size() + " | " + doubleStack + " | " + doubleStack.top());
        doubleStack.push(5.0);
        System.out.println(doubleStack.size() + " | " + doubleStack + " | " + doubleStack.top());

        doubleStack.pop();
        System.out.println(doubleStack.size() + " | " + doubleStack + " | " + doubleStack.top());
        doubleStack.pop();
        System.out.println(doubleStack.size() + " | " + doubleStack + " | " + doubleStack.top());
        doubleStack.pop();
        System.out.println(doubleStack.size() + " | " + doubleStack + " | " + doubleStack.top());
        doubleStack.pop();
        System.out.println(doubleStack.size() + " | " + doubleStack + " | " + doubleStack.top());
        doubleStack.pop();
        System.out.println(doubleStack.size() + " | " + doubleStack + " | " + doubleStack.top());
        
        doubleStack.push(2.0);
        System.out.println(doubleStack.size() + " | " + doubleStack + " | " + doubleStack.top());
        doubleStack.push(4.0);
        System.out.println(doubleStack.size() + " | " + doubleStack + " | " + doubleStack.top());
        doubleStack.pop();
        System.out.println(doubleStack.size() + " | " + doubleStack + " | " + doubleStack.top());
        doubleStack.pop();
        System.out.println(doubleStack.size() + " | " + doubleStack + " | " + doubleStack.top());
        doubleStack.push(5.0);
        System.out.println(doubleStack.size() + " | " + doubleStack + " | " + doubleStack.top());
        doubleStack.push(10.0);
        System.out.println(doubleStack.size() + " | " + doubleStack + " | " + doubleStack.top());
        doubleStack.push(15.0);
        System.out.println(doubleStack.size() + " | " + doubleStack + " | " + doubleStack.top());
        doubleStack.push(20.0);
        System.out.println(doubleStack.size() + " | " + doubleStack + " | " + doubleStack.top() + "\nFor each:");

        for(Double element : doubleStack){
            System.out.println(element);
        }
    }
    
}

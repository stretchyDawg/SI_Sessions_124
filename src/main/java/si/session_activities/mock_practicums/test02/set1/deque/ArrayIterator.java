package si.session_activities.mock_practicums.test02.set1.deque;

import java.util.Iterator;

/**
 * An iterator that can iterate through the elements in an array.
 */
public class ArrayIterator<E> implements Iterator<E> {
    /**
     * The array of elements.
     */
    private Object[] elements;

    /**
     * The iterator's current position in the array.
     */
    private int index;

    /**
     * The number of elements in the array (may be <= the length of the array).
     */
    private int size;
    
    /**
     * Creates a new array iterator that begins iterating over the specified
     * array starting at index 0.
     * 
     * @param elements The array to iterate through.
     * @param size The number of elements stored in the array (may be <= the 
     * array's length).
     */
    public ArrayIterator(Object[] elements, int size) {
        this.elements = elements;
        this.size = size;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < size;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E next() {
        E element = (E)elements[index];
        index++;
        return element;
    }
}

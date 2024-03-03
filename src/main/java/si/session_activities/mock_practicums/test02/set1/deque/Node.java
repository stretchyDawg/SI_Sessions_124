package si.session_activities.mock_practicums.test02.set1.deque;

/**
 * A generic Node. Used to build node-based data structures like stacks, queues,
 * and list.
 * 
 * @author GCCIS Faculty
 */
public class Node<T> {
    /**
     * The value contained in the node.
     */
    private T value;

    /**
     * A reference to the next node in the sequence. May be null.
     */
    private Node<T> next;

    /**
     * Creates a new node with the specified value and next node.
     * 
     * @param value The value contained by the new node.
     * @param next The next node in the sequence.
     */
    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    /**
     * Creates a new node with the specified value. The next node in the 
     * sequence is null.
     * 
     * @param value The value contained in the node.
     */
    public Node(T value) {
        this(value, null);
    }

    /**
     * Returns the value contained by the node.
     * 
     * @return The node's value.
     */
    public T getValue() {
        return value;
    }

    /**
     * Sets the value contained by the node.
     * 
     * @param value The new value.
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * Sets the next node in the sequence.
     * 
     * @param next The next node in the sequence (may be null).
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * Returns the next node in the sequence (may be null).
     * 
     * @return The next node in the sequence.
     */
    public Node<T> getNext() {
        return next;
    }
}

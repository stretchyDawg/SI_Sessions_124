package si.session_activities.mock_practicums.test02.set2.two;

import java.util.Iterator;

import si.data_structures.Node;

/**
 * An iterator that can iterate through a linked-sequence of nodes.
 */
public class NodeIterator<E> implements Iterator<E> {
    /**
     * The current node.
     */
    private Node<E> node;

    /**
     * Creates a new iterator that starts at the specified node.
     * 
     * @param node The node at which iteration should begin.
     */
    public NodeIterator(Node<E> node) {
        this.node = node;
    }

    @Override
    public boolean hasNext() {
        return node != null;
    }

    @Override
    public E next() {
        E element = node.getValue();
        node = node.getNext();
        return element;
    }
}

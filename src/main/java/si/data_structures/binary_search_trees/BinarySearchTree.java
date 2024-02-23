package si.data_structures.binary_search_trees;

public interface BinarySearchTree<E> {
    public void insert(E target);
    public boolean search(E target);
    public int size();
}

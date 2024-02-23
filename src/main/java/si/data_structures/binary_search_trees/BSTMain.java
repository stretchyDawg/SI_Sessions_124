package si.data_structures.binary_search_trees;

public class BSTMain {
    public static <E> void main(String[] args) {
        BinarySearchTree<Integer> bst = new NodeBST<Integer>(3);
        System.out.println(bst);
        bst.insert(4);
        bst.insert(2);
        System.out.println(bst);
        System.out.println(bst.search(3));
        System.out.println(bst.search(6));
    }
}

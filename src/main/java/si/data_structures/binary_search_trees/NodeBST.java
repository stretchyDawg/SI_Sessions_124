package si.data_structures.binary_search_trees;

import si.data_structures.BinaryNode;

public class NodeBST<E extends Comparable <E>> implements BinarySearchTree<E> {
    private BinaryNode<E> root;
    private int size;

    // Constructor:
    public NodeBST(E initialValue){
        this.root = new BinaryNode<E>(initialValue);
        this.size = 1;
    }

    // Getters/Setters:
    public int size(){
        return this.size; 
    }

    // Methods:
    private void insert(BinaryNode<E> node, E value) {
        if(value.compareTo(node.getValue()) < 0) {
            if(node.getLeft() != null) {
                this.insert(node.getLeft(), value);
            } 
            else{
                node.setLeft(new BinaryNode<E>(value));
                this.size++;
            }
        } else {
            if(node.getRight() != null) {
                this.insert(node.getRight(), value);
            } 
            else{
                node.setRight(new BinaryNode<E>(value));
                this.size++;
            }
        }
    }
    @Override
    public void insert(E target){
        insert(this.root, target);
    }

    private boolean search(BinaryNode<E> node, E target) {
        E value = node.getValue();

        if(target.compareTo(value) == 0) {
            return true;
        } 
        else if(target.compareTo(node.getValue()) < 0) {
            BinaryNode<E> left = node.getLeft();
            return left != null ? this.search(left, target) : false;
        } 
        else {
            BinaryNode<E> right = node.getRight();
            return right != null ? this.search(right, target) : false;
        }
    }
    public boolean search(E target) {
        return search(this.root, target);
    }

    // Override Methods:
    @Override
    public String toString(){
        return root.infixTraversal();
    }
}

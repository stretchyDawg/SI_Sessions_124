package si.data_structures;

public class BinaryNode<E>{
    private E value;
    private BinaryNode<E> left;
    private BinaryNode<E> right;

    public BinaryNode(E value, BinaryNode<E> left, BinaryNode<E> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public BinaryNode(E value) {
        this(value, null, null);
    }

    public E getValue() {
        return value;
    }
    public void setValue(E value) {
        this.value = value;
    }

    public BinaryNode<E> getLeft() {
        return left;
    }
    public void setLeft(BinaryNode<E> left) {
        this.left = left;
    }

    public BinaryNode<E> getRight() {
        return right;
    }
    public void setRight(BinaryNode<E> right) {
        this.right = right;
    } 

    public String infixTraversal() {
        String string = "";
        if(left != null) {
            string += left.infixTraversal();
        }
        string += this.value + " ";
        if(right != null) {
            string += right.infixTraversal();
        }
        return string;
    }

    @Override
    public String toString() {
        return "BinaryNode{value=" + this.value
            + ", left=" + this.left
            + ", right=" + this.right 
            + "}";
    }

    public static void main(String[] args) {
        BinaryNode<Integer> root = new BinaryNode<Integer>(2,
            new BinaryNode<Integer>(3,
                new BinaryNode<Integer>(9),
                new BinaryNode<Integer>(4)),
            new BinaryNode<Integer>(7,
                new BinaryNode<Integer>(1),
                new BinaryNode<Integer>(6)));
        
        System.out.println(root);

        System.out.println(root.infixTraversal());
    }
}

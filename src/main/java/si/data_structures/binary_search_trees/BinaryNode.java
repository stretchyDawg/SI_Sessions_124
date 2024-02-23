package si.data_structures.binary_search_trees;

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

    // public boolean search(E target) {
    //     if(target == value) {
    //         return true;
    //     } 
    //     boolean found = false;
    //     if(left != null) {
    //         found = left.search(target);
    //     }
    //     if(!found && right != null) {
    //         found = right.search(target);
    //     }
    //     return found;
    // }

    // Removed Binary Operations:
    //
    // public void binaryInsert(int value) {
    //     if(value < this.value) {
    //         if(left != null) {
    //             left.binaryInsert(value);
    //         } else {
    //             left = new BinaryNode(value);
    //         }
    //     } else {
    //         if(right != null) {
    //             right.binaryInsert(value);
    //         } else {
    //             right = new BinaryNode(value);
    //         }
    //     }
    // }
    //
    // public boolean binarySearch(int target) {
    //     if(target == value) {
    //         return true;
    //     } else if(target < value) {
    //         return left != null ? left.binarySearch(target) : false;
    //     } else {
    //         return right != null ? right.binarySearch(target) : false;
    //     }
    // }

    @Override
    public String toString() {
        return "BinaryNode{value=" + this.value
            + ", left=" + this.left
            + ", right=" + this.right 
            + "}";
    }

    public static void main(String[] args) {
        // line-by-line below
        BinaryNode<Integer> root = new BinaryNode<Integer>(2,
            new BinaryNode<Integer>(3,
                new BinaryNode<Integer>(9),
                new BinaryNode<Integer>(4)),
            new BinaryNode<Integer>(7,
                new BinaryNode<Integer>(1),
                new BinaryNode<Integer>(6)));
        
        System.out.println(root);

        System.out.println(root.infixTraversal());

        // System.out.println("9: " + root.search(9));
        // System.out.println("2: " + root.search(2));
        // System.out.println("10: " + root.search(10));

        // // make nodes
        // BinaryNode bn1 = new BinaryNode(1);
        // BinaryNode bn2 = new BinaryNode(2);
        // BinaryNode bn3 = new BinaryNode(3);
        // BinaryNode bn4 = new BinaryNode(4);
        // BinaryNode bn6 = new BinaryNode(6);
        // BinaryNode bn7 = new BinaryNode(7);
        // BinaryNode bn9 = new BinaryNode(9);
        // // wire them together
        // bn2.setLeft(bn3);
        // bn2.setRight(bn7);
        // bn3.setLeft(bn9);
        // bn3.setRight(bn4);
        // bn7.setLeft(bn1);
        // bn7.setRight(bn6);

    }
}

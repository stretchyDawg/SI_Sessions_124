package si.data_structures;

public class Node<E> {
    private E value;
    private Node<E> next;

    public Node(E value){
        this(value,null);
    }

    public Node(E value, Node<E> next){
        this.value = value;
        this.next = next;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value){
        this.value = value;
    }

    public void setNext(Node<E> next ) {
        this.next = next;
    }

    public Node<E> getNext() {return next;}

    // @Override
    // public String toString(){
    //     String s = value;

    //     Node n = next;
    //     while(n != null){
    //         s += "->" +n.value;
    //         n = n.next;
    //     }
    //     return s += "-> null";

    // }
    @Override
    public String toString(){
        // String s = value + "->";   ///long version
        // if(next!= null){
        //     s += next.toString();
        // }else{
        //     s += "null";
        // }
        // return s;

        // return value + "->" + ((next != null) ? next.toString():"null"); //compacted if statement

        return value + " -> " + next;  //very compact version
    } 
    public static void main(String[] args) {
        Node<String> n = new Node<>("a",new Node<>("b",new Node<>("c")));
        Node<Integer> m = new Node<>(1,new Node<>(2,new Node<>(3)));

        System.out.println(n);
        System.out.println(m);

    }
}

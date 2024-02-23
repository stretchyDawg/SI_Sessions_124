package si.data_structures.lists;

public class ListMain {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<Integer>();
        a.append(1);
        a.append(2);
        a.append(3);
        System.out.println(a);

        for(Integer integer : a){
            System.out.println(integer);
        }

        System.out.println();

        List<Integer> b = new LinkedList<Integer>(); // <---- Uses NodeIterator
        b.append(1);
        b.append(2);
        b.append(3);
        System.out.println(b);

        for(Integer integer : b){
            System.out.println(integer);
        }
    }
}

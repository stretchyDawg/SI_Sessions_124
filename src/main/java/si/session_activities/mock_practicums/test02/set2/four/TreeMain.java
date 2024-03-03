package si.session_activities.mock_practicums.test02.set2.four;

import si.data_structures.binary_search_trees.BinarySearchTree;
import si.data_structures.binary_search_trees.NodeBST;
import si.data_structures.heaps.ArrayHeap;
import si.data_structures.heaps.Heap;
import si.data_structures.lists.ArrayList;
import si.data_structures.lists.List;

public class TreeMain {

    public static void main(String[] args) {
        // 10, 13, 21, 18, 11, 8, 9, 12, 30, 1000
        BinarySearchTree<Integer> bst = new NodeBST<Integer>(10);
        Heap heap = new ArrayHeap();
        heap.add(10);

        List<Integer> numbers = new ArrayList<Integer>();
        numbers.append(13);
        numbers.append(21);
        numbers.append(18);
        numbers.append(11);
        numbers.append(8);
        numbers.append(9);
        numbers.append(12);
        numbers.append(30);
        numbers.append(1000);

        for(Integer num : numbers){
            bst.insert(num);
            heap.add(num);
        }
        System.out.println(bst);
        System.out.println(heap);
    }
}

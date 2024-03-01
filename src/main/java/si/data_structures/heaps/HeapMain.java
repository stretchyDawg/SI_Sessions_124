package si.data_structures.heaps;

public class HeapMain {
    public static void main(String[] args){
        ArrayHeap arrayHeap = new ArrayHeap();
        System.out.println(arrayHeap);

        Heap heap = new ArrayHeap();
        heap.add(50);
        System.out.println(heap);
        heap.add(100);
        System.out.println(heap);
        heap.add(30);
        System.out.println(heap);
        heap.add(10);
        System.out.println(heap);
        heap.add(20);
        System.out.println(heap);

        System.out.println("\nremoving...");
        System.out.println(heap.remove() + ": " + heap);
        System.out.println(heap.remove() + ": " + heap);
        // System.out.println(heap.remove() + ": " + heap);
        // System.out.println(heap.remove() + ": " + heap);
        // System.out.println(heap.remove() + ": " + heap);
    }
}

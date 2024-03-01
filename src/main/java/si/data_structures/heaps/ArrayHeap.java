package si.data_structures.heaps;

import java.util.Arrays;

public class ArrayHeap implements Heap{
    private int[] array;
    private int size;

    public ArrayHeap(){
        this.array = new int[3];
        this.size = 0;
    }

    @Override
    public void add(int value) {
        if(this.size == this.array.length){
            this.array = Arrays.copyOf(array, size+2);
        }
        array[size] = value;

        // Sifting Up:
        for(int child = size, parent = (child-1)/2; this.array[parent] > this.array[child]; child = parent, parent = (child-1)/2){
            swap(parent, child);
        }
        
        this.size++;
    }

    @Override
    public int remove() {
        int temp = array[0];
        this.size--;
        swap(0, size);
        this.array[size] = 0;

        // Sifting Down:
        int parent = 0;
        while(parent < this.size){
            int left = (parent*2) + 1;
            int right = left + 1;
            int destination = parent;
            if(left < this.size){
                destination = left;
            }
            if(right < this.size && this.array[right] < this.array[left]){
                destination = right;
            }
            if(array[destination] < this.array[parent]){
                swap(destination, parent);
                parent = destination;
            }
            else{
                break;
            }
        }
        return temp;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString(){
        return Arrays.toString(this.array) + ", " + this.size;
    }

    private void swap(int a_index, int b_index){
        if(a_index != b_index){
            int temp = this.array[a_index];
            this.array[a_index] = this.array[b_index];
            this.array[b_index] = temp;
        }
    }
}

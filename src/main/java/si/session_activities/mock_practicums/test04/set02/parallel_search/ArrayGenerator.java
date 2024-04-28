package si.session_activities.mock_practicums.test04.set02.parallel_search;

import java.util.Random;

public class ArrayGenerator {
    /**
     * Generates an array of random integers.
     * @param size The size of the array.
     * @param min The minimum value of the array elements.
     * @param max The maximum value of the array elements.
     * @return An array of random integers.
     */
    public static int[] generateRandomArray(int size, int min, int max) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] randomArray = generateRandomArray(1000000, 0, 10000000); // Array of 1,000 elements ranging from 0 to 100
        // int index = 0;
        // for(int num : randomArray){
        //     System.out.println(index + ": " + num);
        //     index++;
        // }
        System.out.println("Array generated with size: " + randomArray.length);
    }
}
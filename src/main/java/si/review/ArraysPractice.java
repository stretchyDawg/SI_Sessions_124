package si.review;

import java.util.Arrays;

public class ArraysPractice {
    public static void main(String[] args) {
        int[] numbers = new int[5];
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = i*i;
            System.out.println(numbers[i]);
        }
        System.out.println(Arrays.toString(numbers));

    }
}

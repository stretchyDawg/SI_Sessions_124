package si.session_activities.mock_practicums.test03.set2.four;

import java.util.Arrays;
import java.util.List;

public class Streams {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5); 
        // ^ There are other ways to make a list.

        System.out.println("Even numbers:");
        numbers.stream().filter(num -> num % 2 == 0).forEach(System.out::println);

        int sum = numbers.stream().mapToInt(num -> num).sum();
        System.out.println("Sum of all integers: " + sum);

        long count = numbers.stream().filter(num -> num > 3).count();
        System.out.println("Number of integers greater than 3: " + count);
    }
}


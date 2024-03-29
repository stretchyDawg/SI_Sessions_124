package si.session_activities.unit09;

import java.util.ArrayList;
import java.util.List;

public class SeriesMain {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1); 
        numbers.add(2); 
        numbers.add(3); 
        numbers.add(4); 
        numbers.add(5); 
        
        numbers.stream().filter(num -> num % 2 != 0).forEach(System.out::println);

        int sumOfSquaresOfOddNumbers = numbers.stream().filter(num -> num % 2 != 0).mapToInt(num -> num * num).sum();
        System.out.println(sumOfSquaresOfOddNumbers);

        long countOfEven = numbers.stream().filter(num -> num % 2 == 0).count();
        System.out.println(countOfEven);
    }
}

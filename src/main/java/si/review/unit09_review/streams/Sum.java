package si.review.unit09_review.streams;

import java.util.ArrayList;
import java.util.List;

public class Sum {
    //static int sum = 0;





    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1); // 1
        numbers.add(2); // 3
        numbers.add(3); // 6
        numbers.add(4); // 10
        numbers.add(5); // 15

        numbers.stream().forEach(System.out::println);
        numbers.stream().forEach(num -> num = num * 2);
        System.out.println();
        numbers.stream().forEach(System.out::println);
        System.out.println();
        numbers.stream().map(num -> num * 2).forEach(System.out::println);
        System.out.println();
        numbers.stream().filter(num -> num % 2 == 0).forEach(System.out::println);
        System.out.println();
        numbers.stream().mapToDouble(num -> num).forEach(System.out::println);





        // int sum = 0;
        // numbers.stream().forEach(num -> sum += num);
        // System.out.println(sum);



        int sum2 = numbers.stream().mapToInt(e -> e).sum();
        System.out.println("\n" + sum2);
    }



}

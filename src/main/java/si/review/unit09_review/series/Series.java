package si.review.unit09_review.series;
import java.util.Optional;
import java.util.stream.Stream;

public class Series {
    private static double product = 1;
    public static Stream<Double> makeStream(int length){
        Stream.Builder<Double> builder = Stream.builder();
        for(int i = 1; i < length + 1; i++){
            builder.add((double)i);
        }
        Stream<Double> stream = builder.build();
        return stream;
    }

    public static double fibForEach(int num){
        Stream<Double> numStream = makeStream(num);
        numStream.forEach(n -> product = n*product);
        return product;
    }

    public static double fibReduce(int num){
        Stream<Double> numStream = makeStream(num);
        Optional<Double> numStreamOpt =  numStream.reduce((n1, n2) -> n1*n2); // WTF is an optional LOL
        return numStreamOpt.get();
    }

    public static double piGregoryLeibniz(int num){
        Stream<Double> numStream = makeStream(num);
        double sum = numStream.mapToDouble(n -> ( (Math.pow(-1, n))/((2*n)+1) )).sum();
        return (sum+1)*4;
    }

    public static double piNilikantha(int num){
        Stream<Double> numStream = makeStream(num);
        double sum = numStream.mapToDouble(n -> ( (Math.pow(-1, (n+1) % 2)) * ( 4 / ((2*n) * ((2*n)+1) * ((2*n)+2)) ) )).sum();
        return sum+3;
    }

    public static void main(String[] args){
        System.out.println();
        Stream<Double> doubleStream = makeStream(10);
        Stream<Double> doubleStream2 = makeStream(30);
        doubleStream.forEach(n -> System.out.print(n + " "));
        System.out.println();
        doubleStream2.forEach(n -> System.out.print(n + " "));


        System.out.println("\n\nFactorial Functions:");
        // Can only do one function at a time because it is manipulating a global variable.
        // System.out.println("8!: " + fibForEach(8)); // 40320
        System.out.println("ForEach: 5!: " + fibForEach(5)); // 120
        // System.out.println("2!: " + fibForEach(2)); // 2

        System.out.println("Reduce:  2!: " + fibReduce(2)); // 2
        System.out.println("Reduce:  5!: " + fibReduce(5)); // 120
        System.out.println("Reduce:  8!: " + fibReduce(8)); // 40320

        System.out.println("\nPi Functions:");
        System.out.println(piGregoryLeibniz(2000000));
        System.out.println(piNilikantha(2000000));

        
    }
}

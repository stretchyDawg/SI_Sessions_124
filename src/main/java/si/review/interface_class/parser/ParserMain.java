package si.review.interface_class.parser;

public class ParserMain {
    public static void main(String[] args){
        System.out.println("Constant:");
        Expression pi = new Constant(3.14);
        System.out.println(pi.evaluate());

        System.out.println("\nIncrement:");
        Expression ten = new Constant(10);
        Expression increment1 = new Increment(ten);
        System.out.println(increment1.evaluate());
        Expression increment2 = new Increment(increment1);
        System.out.println(increment2.evaluate());

        System.out.println("\nDecrement:");
        Expression decrement1 = new Decrement(ten);
        System.out.println(decrement1.evaluate());
        Expression decrement2 = new Decrement(decrement1);
        System.out.println(decrement2.evaluate());

        Expression one = new Constant(1);
        Expression two = new Constant(2);
        System.out.println("\nAddition: ");
        Expression addition1 = new Addition(one, two);
        System.out.println(addition1.evaluate());
        Expression addition2 = new Addition(ten, ten);
        System.out.println(addition2.evaluate());
    }
}

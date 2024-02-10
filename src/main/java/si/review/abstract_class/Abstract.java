package si.review.abstract_class;

public class Abstract {
    public static void main(String[] args) {
        // Thermometer x = new Thermometer(20); // Gives an error because it cannot be instantiated
        
        Thermometer celsius = new Celsius(0);
        Celsius celsius2 = new Celsius(0);

        Thermometer fahrenheit = new Fahrenheit(0);
        Fahrenheit fahrenheit2 = new Fahrenheit(0);

        System.out.println(celsius.getBoilingPoint());
        System.out.println(celsius2.getBoilingPoint());
        System.out.println(fahrenheit.getBoilingPoint());
        System.out.println(fahrenheit2.getBoilingPoint());
        System.out.println(fahrenheit);
    }
}

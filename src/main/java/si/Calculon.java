package unit01;

import java.util.Scanner;

public class Calculon {
    public static double add(double a, double b){
        return a + b;
    }

    public static double subtract(double a, double b){
        return a - b;
    }

    public static double multiply(double a, double b){
        return a * b;
    }

    public static double divide(double a, double b){
        return a / b;
    }

    public static double exponent(double number, int power){
        double result = number;
        for(int i = 0; i < power-1; i++){
            result = result*number;
        }
        return result;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a double: ");
        double number1 = scan.nextDouble();
        System.out.println("Please enter another double: ");
        double number2 = scan.nextDouble();
        System.out.println("Addition: " + add(number1, number2));
        System.out.println("Subtraction: " + subtract(number1, number2));
        System.out.println("Multiplication: " + multiply(number1, number2));
        System.out.println("Division: " + divide(number1, number2));
        System.out.println("Exponentiation: " + exponent(number1, (int)number2));
        scan.close();
    }


}

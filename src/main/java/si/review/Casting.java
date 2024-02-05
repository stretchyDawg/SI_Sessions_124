package si.review;

public class Casting {
    public static void main(String[] args) {
        int a = 5;
        long b = (int)a;
        System.out.println("int to long: " + a + ", " + b);

        long c = 3000000001l;
        int d = (int)c;
        System.out.println("long to int: " + c + ", " + d);

        int g = 124;
        char h = (char)g;
        System.out.println("int to char: " + g + ", " + h);

        char e = 'a';
        int f = (char)e;
        System.out.println("char to int: " + e + ", " + f);
    }
}

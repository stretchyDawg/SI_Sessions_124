package si.session_activities.unit10;

public class OneTwoThree {
    public static void main(String[] args) throws InterruptedException {
        Thread one = new Thread(() -> System.out.println("One"));
        Thread two = new Thread(() -> System.out.println("Two"));
        Thread three = new Thread(() -> System.out.println("Three"));
        Thread four = new Thread(() -> System.out.println("Four"));
        Thread five = new Thread(() -> System.out.println("Five"));
        Thread six = new Thread(() -> System.out.println("Six"));

        one.start();
        one.join();
        two.start();
        two.join();
        three.start();
        three.join();   
        four.start();
        four.join();
        five.start();
        five.join();
        six.start();
        six.join();  
    }
}

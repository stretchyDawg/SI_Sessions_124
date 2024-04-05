package si.session_activities.unit10;

import java.util.stream.IntStream;

public class SI_Hund {
    public static void main(String[] args) {
        // Thread threadEven = new Thread(() -> IntStream.range(0, 100).filter(n -> n % 2 == 0).forEach(System.out::println)); 
        // Thread threadOdd = new Thread(() -> IntStream.range(0, 100).filter(n -> n % 2 != 0).forEach(System.out::println)); 
        
        Thread even = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 101; i += 2){
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        });


        Thread odd = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 101; i += 2){
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        });
        // threadEven.start(); 
        // threadOdd.start();

        even.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        odd.start();
    }
}

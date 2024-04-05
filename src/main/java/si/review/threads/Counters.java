package si.review.threads;

import java.util.Scanner;

public class Counters {
    
    public static void main(String[] args) throws InterruptedException{
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter an integer: ");        
        int n = scan.nextInt();
        
        Thread[] counters = new Thread[n];
        for(int i = 1; i < n+1; i++){
            RunnableCounter counter = new RunnableCounter("Counter " + i);
            counters[i-1] = new Thread(counter);
            counters[i-1].start();
        }
        for(int i = 1; i < n+1; i++){
            counters[i-1].join();
        }
        System.out.println("Counters all done!");

        scan.close();
    }
}

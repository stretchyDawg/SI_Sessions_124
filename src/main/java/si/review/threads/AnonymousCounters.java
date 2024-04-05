package si.review.threads;

import java.util.Scanner;

public class AnonymousCounters {
    public static void counter(String name){
        for(int i = 1; i <= 101; i++){
            System.out.println(name + ": " + i);
        }
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter an integer: ");        
        int n = scan.nextInt();

        for(int i = 0; i < n; i++){
            Thread countThread = null;
            String name = "Counter " + i;
            if(i % 2 == 0){                                          // Made so that it uses each method every other iteration
                countThread = new Thread(new Runnable(){
                    public void run(){ counter (name); }             // Anon Class
                });
            }
            else{
                countThread = new Thread (() -> counter(name));      // Lambda
            }
            countThread.start();
        }

        scan.close();
    }
}

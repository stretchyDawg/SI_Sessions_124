package si.session_activities.unit10;

/*
ONE TWO THREE
With your partner, create a OneTwoThree.java class that will only have a main method. 
Inside the main method, create SIX Thread instances (you can EASILY do this using Lambdas).
The first thread you make will print out “One”. The second one you make will print out “Two”, and so on… (you can make more than three if you’d like).
Start all 3 threads.
When you run them you’ll notice they are printing in random order. Make it so that they will ALWAYS print in this order: “One”, “Two”, “Three”... etc.
 */

public class SI_Seq {
    public static void main(String[] args) throws InterruptedException{ 


        Thread thread1 = new Thread(() -> System.out.println(1)); 
        Thread thread2 = new Thread(() -> System.out.println(2)); 
        Thread thread3 = new Thread(() -> System.out.println(3)); 
        Thread thread4 = new Thread(() -> System.out.println(4)); 
        Thread thread5 = new Thread(() -> System.out.println(5)); 
        Thread thread6 = new Thread(() -> System.out.println(6));
        
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
        thread3.join();
        thread4.start();
        thread4.join();
        thread5.start();
        thread5.join();
        thread6.start();
        thread6.join();
        
        







    }
}

package si.session_activities.unit11.class_files;

/**
 * COUNTER:
 * With your partner, create a Counter.java file with a main method:
 * 
 * - Step 1: Inside the class, create a static int array field called counter,
 * it will be an array of size 1. Set the only value of the counter to zero.
 * 
 * - Step 2: Create a static final Object field called lock, this is what you
 * can use for your synchronized blocks.
 * 
 * - Step 3: Create a constructor for the new Counter.java class.
 * 
 * - Step 4: Have Counter.java implement Runnable.java. Inside the inherited
 * run() method, increment the value in counter[0] 10,000 times.
 * 
 * - Step 5: Create and start a thread that uses the Counter run() method we
 * have just made. Then print the value inside of the array.
 * 
 * - Step 6: Now, create 10 threads the same way, run each of those threads and
 * print the value inside of the array. Run the program multiple times.
 * 
 * - Step 7: Synchronize the block of code that is incrementing the value inside
 * of the array, then print the value inside of the array and see the difference.
 */

public class SI_Counter implements Runnable {
    private static int[] counter = new int[1];
    private static final Object lock = new Object();

    public SI_Counter() {
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (lock) {
                counter[0] += 1;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(new SI_Counter()).start();
        }
        Thread.sleep(10);
        System.out.println(counter[0]);
    }
}

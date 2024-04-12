package si.review.threads.sync;

public class TheCount implements Runnable{
    private static int[] COUNT = new int[1];
    private final int id;

    public TheCount(int id){
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Counter: " + id + " is starting...");
        
        for(int i = 0; i < 100000; i++){
            // System.out.println(this.id + " : " + i + " looping...");     // <-- Uncomment this to see what's looping
            synchronized(COUNT){                                // <-- Putting this on the inside of the for loop makes it faster as they are looping through the for loop all at once.
                COUNT[0]++;
            }
        }

        System.out.println("Counter: " + id + " has ended!");
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 10; i++){
            TheCount counter = new TheCount(i);
            Thread thread = new Thread(counter);
            thread.start();
        }
        
        Thread.sleep(1000);
        System.out.println(COUNT[0]);

    }
}

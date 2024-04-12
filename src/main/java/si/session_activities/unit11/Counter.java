package si.session_activities.unit11;

public class Counter implements Runnable {
    private static int[] counter;
    private static final Object lock = new Object(); 
    
    @Override
    public void run() {
        synchronized(lock){
            for(int i = 0; i < 1000000; i++){
                counter[0]++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        counter = new int[1];
        counter[0] = 0;

        for(int i = 0; i < 10; i++){
            Thread thread = new Thread(new Counter());
            thread.start();
        }

        Thread.sleep(1000);
        System.out.println(counter[0]);
    }

}

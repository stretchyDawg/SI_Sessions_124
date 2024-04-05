package si.review.threads.sleep_join;

public class SleepThread2 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable(){
            @Override
            public void run() {
                int number = 0;
                while(number < 11){
                    System.out.println(number);
                    number++;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {}
                }
            }
        });

        thread1.start();

        while(thread1.isAlive()){
            Thread.sleep(10);
        }

        int number = 10000;
        while(number < 10011){
            System.out.println(number);
            number++;
            try {
                Thread.sleep(1000);   // <-- Making main thread sleep 
            } catch (InterruptedException e) {}
        }
    }
}

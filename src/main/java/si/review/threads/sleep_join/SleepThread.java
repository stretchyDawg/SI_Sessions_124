package si.review.threads.sleep_join;

public class SleepThread {
    


    public static void main(String[] args) {
        Thread numbers = new Thread(new Runnable() {
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
        Thread numbers2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int number = 100;
                while(number < 111){
                    System.out.println("2 second thread: " + number);
                    number++;
                    try {
                        Thread.sleep(2000); 
                    } catch (InterruptedException e) {}
                }
            }
        });

        numbers.start();
        numbers2.start();

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

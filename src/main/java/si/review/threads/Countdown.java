package si.review.threads;

public class Countdown implements Runnable {


    @Override
    public void run() {
        for(int i = 10; i > 0; i--){
            System.out.println("T-" + i);
            try {
                Thread.sleep(1000);
            } 
            catch (InterruptedException e) {
                System.out.println("Interrupted!");
            }
        }
        System.out.println("Liftoff!!");
    }

    public static void main(String[] args){
        Countdown countdown = new Countdown();
        Thread cd = new Thread(countdown);
        cd.run();
    }
    
}

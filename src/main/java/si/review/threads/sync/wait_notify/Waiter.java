package si.review.threads.sync.wait_notify;

public class Waiter implements Runnable{
    private Object lock;
    private int id;

    public Waiter(Object lock, int id) {
        this.lock = lock;
        this.id = id;
    }

    @Override
    public void run() {
        synchronized(this.lock){
            System.out.println(this.id + " started...");
            try {
                this.lock.wait();
            } catch (InterruptedException e) {}
            System.out.println("Done waiting!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        for(int i = 0; i < 10; i++){
            Waiter waiter = new Waiter(lock, i);
            Thread thread = new Thread(waiter);
            thread.start();
        }
        for(int i = 6; i > 0; i--){
            System.out.println(i + "...");
            Thread.sleep(1000);
        }
        synchronized(lock){
            lock.notifyAll();
            System.out.println("Thread notified!");
        }

    }
}

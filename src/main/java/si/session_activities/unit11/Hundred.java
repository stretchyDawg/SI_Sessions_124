package si.session_activities.unit11;

public class Hundred {
    private static final Object lock = new Object();
    private static int currentNumber = 1;

    public static void main(String[] args) {
        Thread oddThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (currentNumber < 100) {
                    synchronized (lock) {
                        if (currentNumber % 2 == 1) { 
                            System.out.println(currentNumber);
                            currentNumber++;
                            lock.notify(); 
                        } else {
                            try {
                                lock.wait(); 
                            } catch (InterruptedException e) {}
                        }
                    }
                }
            }
        });
        
        Thread evenThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (currentNumber <= 100) {
                    synchronized (lock) {
                        if (currentNumber % 2 == 0) { 
                            System.out.println(currentNumber);
                            currentNumber++;
                            lock.notify();
                        } else {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {}
                        }
                    }
                }
            }
        });
    
        oddThread.start();
        try {
            Thread.sleep(100); 
        } catch (InterruptedException e) {}
        evenThread.start();
    }
}
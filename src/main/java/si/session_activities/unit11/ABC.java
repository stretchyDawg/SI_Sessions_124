package si.session_activities.unit11; 

public class ABC {
    private static final Object lock = new Object();

    public static void main(String[] args) {
        
        Thread abc = new Thread(new Runnable() {
            @Override
            public void run() {
                char c = 'a';
                c--;
                while (c < 'z') {
                    synchronized (lock) {
                        c++;
                        System.out.println(c);
                        lock.notify(); 
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {} 
                    }
                }
            }
        });
        
        Thread oneTwoThree = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i < 26) {
                    synchronized (lock) {
                        i++;
                        System.out.println(i);
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {}
                    }
                }
            }
        });
    
        abc.start();
        try {
            Thread.sleep(100); 
        } catch (InterruptedException e) {}
        oneTwoThree.start();
    }
}

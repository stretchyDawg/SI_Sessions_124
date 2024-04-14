package si.session_activities.unit11;

public class PingPong {
    private final static Object lock = new Object();
    private static boolean pingTurn = true;

    public static void main(String[] args) {
        Thread ping = new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    synchronized(lock) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {}
                        while (!pingTurn) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {}
                        }
                        System.out.println("Ping");
                        pingTurn = false; // Switch turn to Pong
                        lock.notifyAll(); // Notify the Pong thread
                    }
                }
            }
        });
        Thread pong = new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    synchronized (lock) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {}
                        while (pingTurn) {
                            try {
                                lock.wait(); // Wait for the Pong turn
                            } catch (InterruptedException e) {}
                        }
                        System.out.println("Pong");
                        pingTurn = true; // Switch turn back to Ping
                        lock.notifyAll(); // Notify the Ping thread
                    }
                }
            }
        });
    
        ping.start();
        pong.start();
    }
}


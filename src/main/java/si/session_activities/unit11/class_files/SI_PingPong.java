package si.session_activities.unit11.class_files;


/**
    PING PONG:
    With your partner, create a PingPong.java file with a main method.
    - Step 1: Inside the class, create a static lock field same as 
              before and a static boolean field called isPing.
    - Step 2: In the main method, create two threads, a Ping 
              thread and a Pong thread.
    - Step 2a: The Ping thread should print "\t\tPing" when 
               isPing is true **10 times**. (You need the '\t\t')
    - Step 2b: The Pong thread should print "Pong" when 
               isPing is false **10 times**.
    - Step 3: Start the two threads and see the outcome. 
    - Step 4: Have it so that the outcome prints Ping and 
              Pong in alternating order (\t\tPing... Pong... \t\tPing... etc...) 
    - Step 5: In the main method, start both threads and see the outcome :)
 */
public class SI_PingPong {
    private static Object key;
    private static boolean isPong;

    public static void main(String[] args) {
        key = new Object();
        
        Thread ping = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized(key){
                    if(isPong){
                        System.out.println("\t\tPing");
                        try {
                            key.wait();
                        } catch (InterruptedException e) {}
                    }
                    isPong = !isPong;
                    key.notifyAll();
                }
            }
        });
        Thread pong = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized(key){
                    if(!isPong){
                        System.out.println("Pong");
                        try {
                            key.wait();
                        } catch (InterruptedException e) {}
                    }
                    isPong = !isPong;
                    key.notifyAll();
                }
            }
        });

        ping.start();
        pong.start();
    }
}

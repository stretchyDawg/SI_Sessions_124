package si.review.threads.making_threads;

public class RunnableExample implements Runnable {
    private final int id;

    public RunnableExample(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println (id);
    }
     
    public static void main(String[] args) {
        Runnable example = new RunnableExample(1);
 
        Thread exampleThread = new Thread(example); // <-- Making thread with Runnable implementation
        exampleThread.start();
    }
}
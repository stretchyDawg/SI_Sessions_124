package si.review.threads;

public class RunnableCounter implements Runnable {

    private String name;

    public RunnableCounter(String name){
        this.name = name;
    }

    @Override
    public void run() {
        for(int i = 1; i < 101; i++){
            System.out.println(name + ": " + i);
        }
    }

    public static void main(String[] args){
        RunnableCounter count = new RunnableCounter("Counter 2");
        Thread counter = new Thread(count);
        counter.start();
        counter = new Thread(count);
        counter.start();
    }
    
}

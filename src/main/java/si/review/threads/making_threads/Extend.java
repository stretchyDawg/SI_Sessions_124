package si.review.threads.making_threads;

public class Extend extends Thread{
    private final int id;

    public Extend(int id) {
        this.id = id;
    }
    
    @Override
    public void run() {
        System.out.println(id);
    }
     
    public static void main(String[] args) {
        Thread example = new Extend(1);
        example.start();
    }
}

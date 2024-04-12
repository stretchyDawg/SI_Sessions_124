package si.review.threads.deadlock;

public class Deadlock implements Runnable {
    private String name; 
    private Object lockOne;
    private Object lockTwo;
    
    public Deadlock(String name, Object lockOne, Object lockTwo) {
        this.name = name;
        this.lockOne = lockOne;
        this.lockTwo = lockTwo;
    }

    @Override
    public void run() {
        while(true){
            System.out.println(name + " getting lock on " + lockOne);
            synchronized(lockOne){
                System.out.println(name + " got lock! Getting lock on " + lockTwo);
                synchronized(lockTwo){
                    System.out.println(name + " got both locks! Releasing " + lockTwo);
                }
                System.out.println(name + " releasing " + lockOne);
            }
        }
    }
    
    public static void main(String[] args) {
        String lockA = "A";
        String lockB = "B";

        new Thread(new Deadlock("DL1", lockA, lockB)).start();
        new Thread(new Deadlock("DL2", lockA, lockB)).start();
    }
}

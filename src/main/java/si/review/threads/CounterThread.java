package si.review.threads;

public class CounterThread extends Thread{
    private final String name;

    // Constructors
    public CounterThread(String name){
        this.name = name;
    }

    @Override
    public void run(){
        for(int i = 1; i < 101; i++){
            System.out.println(name + ": " + i);
        }
    }

    public static void main(String[] args){
        Thread counter = new CounterThread("Counter 1");
        counter.start();
        
        int count = 0;
        while(counter.isAlive()){
            try{
                Thread.sleep(50);
            }
            catch(InterruptedException e){}
            count++;
        }
        System.out.println("Looped " + count + " time(s).");

        char ch = 'A';
        while(ch <= 'Z'){
            System.out.print(ch + " ");
            ch++;
        }
        System.out.println();
        // counter.start(); Thread DEAD
    }   
}

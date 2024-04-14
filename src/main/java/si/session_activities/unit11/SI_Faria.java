package si.session_activities.unit11;

public class SI_Faria implements Runnable {
    String name;
    private Object lock;

    public SI_Faria(String name, Object lock){
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {
        if (name.equals("Alpha")){
                synchronized(lock){
                    try {
                        for (char p='a'; p<='z'; p++){
                            System.out.println(p);
                            lock.notifyAll();
                            lock.wait();
                        }
                    } catch (InterruptedException e) {}
                }
        }
        else if (name.equals("Num")){
            synchronized(lock){
                try {
                    for (int i=1; i<=26; i+=1){
                        System.out.println(i);
                        lock.notifyAll();
                        lock.wait();
                    }
                } catch (InterruptedException e) {}
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        //Thread[] threads = new Thread[2];
    
        SI_Faria runnable = new SI_Faria("Alpha", lock);
        SI_Faria runnable2 = new SI_Faria("Num", lock);
        
        Thread thread1 = new Thread(runnable2);
        Thread thread2 = new Thread(runnable);
      

        thread2.start();
        thread1.start();

        System.out.println("The end");

    }
    
}    


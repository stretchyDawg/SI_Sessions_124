package si.session_activities.unit10;

public class ThreadTraining {
    static int value = 0;

    public static class OneTen extends Thread{
        @Override
        public void run() {
            for(int i = 0; i < 10; i++){
                value++;
                System.out.println("Thread 1: " + value);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
            }
        }
    }
    
    public static void main(String[] args) {
        Thread oneTen = new OneTen();
        
        Thread twoTen = new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i = 0; i < 10; i++){
                    value+=1;
                    System.out.println("Thread 2: " + value);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {}
                }
            }
        });
        
        Thread threeTen = new Thread(() -> {
            for(int i = 0; i < 10; i++){
                value += 1;
                System.out.println("Thread 3: " + value);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {}
            }
        });

        oneTen.start(); 
        twoTen.start();
        threeTen.start();
    }
}

package si.session_activities.unit10;

public class SI_Training {
    public static class Thread1 extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                value+=1;
                System.out.println(value);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {                }
            }
        }
    }

    static int value =0;

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        thread1.start();
    }
}

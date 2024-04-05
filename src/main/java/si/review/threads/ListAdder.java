package si.review.threads;

import java.util.ArrayList;

public class ListAdder implements Runnable {

    private ArrayList<Integer> sharedList;
    private int num;

    public ListAdder(ArrayList<Integer> sharedList, int num){
        this.sharedList = sharedList;
        this.num = num;
    }

    @Override
    public void run() {
        for(int i = 0; i < num; i++){
            sharedList.add(i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> sharedList = new ArrayList<>();
        Thread[] threads = new Thread[100];
        for(int i = 0; i < 100; i++){
            threads[i] = new Thread(new ListAdder(sharedList, 50));
            threads[i].start();
        }
        for(int i = 0; i < 100; i++){
            threads[i].join();
        }
        System.out.println("Shared List has " + sharedList.size() + " elements.");
    }
    
}

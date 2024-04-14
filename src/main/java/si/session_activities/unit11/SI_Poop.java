package si.session_activities.unit11;

import java.util.List;

import java.util.ArrayList;

public class SI_Poop implements Runnable{
    private String name;
    private Object obj=new Object();

    public SI_Poop(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        if(name.equals("A")){
            synchronized(obj){
                try {
                    for(char a='a'; a<'z';a++){
                        System.out.println(a);
                        obj.notifyAll();
                        obj.wait();
                    }
                } catch (InterruptedException e) {}   
            }
        }
        if(name.equals("Num")){
            synchronized(obj){
                try {
                    for(int a=1; a<26;a++){
                        System.out.println(a);
                        obj.notifyAll();
                        obj.wait();
                    }
                } catch (InterruptedException e) {}
            }
        }
    }

    public static void main(String[] args) {
        Thread threadA= new Thread(new SI_Poop ("A"));
        Thread thread1= new Thread(new SI_Poop("Num"));
    
        threadA.start();
        thread1.start();
    }
}

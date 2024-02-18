package si.session_activities.unit04.username.username.username.model;

import java.util.Random;

public class Username {
    private String username;
    private Random RNG;
    private USObserver observer;
    public Username (){
        this.username = "";
        this.RNG = new Random();
    }

    public void setObserver(USObserver observer){
        this.observer = observer;
    }

    public USObserver getObserver(){
        return this.observer;
    }

    public String getUsername(){
        return username;
    }

    public void makeUsername(String fullName){
        username = "";
        String[] tokens = fullName.trim().split(" ");
        if (tokens.length == 2){
            username += tokens[0].toUpperCase().charAt(0);
            username += tokens[1];
            username += RNG.nextInt(1,25);
        }
        else{
            username += tokens[0].toUpperCase().charAt(0);
            username += tokens[0].toUpperCase().charAt(1);
            username += RNG.nextInt(1,25);
        }

       
    } 


    public static void main(String[] args) {
        Username us = new Username();
        us.makeUsername("Faria Sultana");
        System.out.println(us.getUsername());
    }
}

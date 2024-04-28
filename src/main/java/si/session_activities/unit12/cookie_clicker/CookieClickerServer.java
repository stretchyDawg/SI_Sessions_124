package si.session_activities.unit12.cookie_clicker;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import si.review.networking_review.duplexer.Duplexer;

public class CookieClickerServer {
    private ServerSocket serverSocket;
    private Duplexer duplexer;
    private int cookies;

    public CookieClickerServer(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
        System.out.println("\nCookie Clicker Server! " + 
                           "\nServer Address: " + InetAddress.getLocalHost().getHostAddress() + 
                           "\nServer Port " + port);
        this.cookies = 0;
    }

    public void start() {
        try {
            System.out.print("Waiting for clients...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("\nClient connected.\n");
            duplexer = new Duplexer(clientSocket);
            
            String message = ""; 
            while(!message.equals("exit")){
                message = duplexer.read();
                message = message.toLowerCase();
                
                if(message.equals("help")){
                    System.out.println("\nCommands: \n\t" + 
                        "\"click\" - Clicks the cookie.\n\t" + 
                        "\"cursor\" - Adds a cursor for 20 clicks.\n\t" + 
                        "\"grandma\" - Adds a grandma for 100 clicks.\n\t" + 
                        "\"farm\" - Adds a farm for 500 clicks.\n\t" + 
                        "\"super grandma\" - Adds a Super Grandma for 1000 clicks.\n\t" + 
                        "\"exit\" - Exits the game.\n"
                    );
                }
                else if(message.equals("click")){
                    this.cookies++;
                }
                else if(message.equals("cursor")){ // Adds one to cookies every second for 20
                    if(this.cookies >= 20){
                        this.cookies -= 20;

                        Thread cursor = new Thread(() -> {
                            while(true){
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {}
                                this.cookies++;
                            }
                        });
                        cursor.start();
                    }
                    else{
                        System.out.println("Not enough cookies! You need 20 to buy a cursor.");
                    }
                }
                else if(message.equals("grandma")){ // Adds 5 to cookies every second for 100
                    if(this.cookies >= 100){
                        this.cookies -= 100;

                        Thread grandma = new Thread(() -> {
                            while(true){
                                try {
                                    Thread.sleep(1000/5);
                                } catch (InterruptedException e) {}
                                this.cookies++;
                            }
                        });
                        grandma.start();
                    }
                    else{
                        System.out.println("Not enough cookies! You need 100 to buy a grandma.");
                    }
                }
                else if(message.equals("farm")){ // Adds 100 to cookies every second for 500
                    if(this.cookies >= 500){
                        this.cookies -= 500;

                        Thread farm = new Thread(() -> {
                            while(true){
                                try {
                                    Thread.sleep(1000/100);
                                } catch (InterruptedException e) {}
                                this.cookies++;
                            }
                        });
                        farm.start();
                    }
                    else{
                        System.out.println("Not enough cookies! You need 500 to buy a farm.");
                    }
                }
                else if(message.equals("super grandma")){ // Adds 1000 to cookies every second for 1000
                    if(this.cookies >= 1000){
                        this.cookies -= 1000;

                        Thread superGrandma = new Thread(() -> {
                            while(true){
                                try {
                                    Thread.sleep(1000/1000);
                                } catch (InterruptedException e) {}
                                this.cookies++;
                            }
                        });
                        superGrandma.start();
                    }
                    else{
                        System.out.println("Not enough cookies! You need 500 to buy a farm.");
                    }
                }
                System.out.println("Cookies: " + this.cookies);
            }

            try {
                System.out.println("\nGame over! Final cookie count: " + this.cookies);
                if (duplexer != null) {
                    duplexer.close();
                }
                serverSocket.close();
            } catch (IOException e) {e.printStackTrace();}
        } catch (IOException e) {e.printStackTrace();} 
    }

    public static void main(String[] args) throws IOException {
        CookieClickerServer server = new CookieClickerServer(54321);
        server.start();
    }
}

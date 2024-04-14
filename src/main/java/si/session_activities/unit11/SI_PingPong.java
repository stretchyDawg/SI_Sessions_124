package si.session_activities.unit11;


/**
 * PING PONG:
With your partner, create a PingPong.java file with a main method.
- Step 1: Inside the class, create a lock field same as before and a static boolean field 
          called isPing.
- Step 2: In the main method, create two threads, a Ping thread and a Pong thread. You 
          can make them any way you want (I suggest using anon classes). In both of them, 
          put a for loop that loops 10 times (this is done to simulate 10 turns). 
- Step 3a: The Ping thread should print "Ping" when pingTurn is true.
- Step 3b: The Pong thread should print "Pong" when pingTurn is false.
- Step 4: In each thread, synchronize on the lock object and use wait() and notifyAll() 
          to manage which thread is allowed to print its message. The thread that just 
          printed should call notifyAll() and then immediately call wait() to allow the 
          other thread to run.
- Step 5: In the main method, start both threads
 */
public class SI_PingPong {
    
}

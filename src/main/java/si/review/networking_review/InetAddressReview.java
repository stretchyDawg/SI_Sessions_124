package si.review.networking_review;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Basically a way to access all of the fields of your computer.
 * In other programming languages, there are similar ways to do this.
 */
public class InetAddressReview {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress host = InetAddress.getLocalHost();
        String hostname = host.getHostName();
        String address = host.getHostAddress();

        System.out.println("\nHostname: " + hostname);
        System.out.println("Address: " + address);
    }
}

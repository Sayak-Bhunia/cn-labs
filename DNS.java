import java.net.*;
import java.io.*;
import java.util.*;

public class DNS {
    public static void main(String[] args) {
        int choice;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        do {
            System.out.println("\nMenu:\n1. DNS Lookup\n2. Reverse DNS Lookup\n3. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(in.readLine());

                if (choice == 1) {
                    System.out.print("Enter Host Name: ");
                    String hostName = in.readLine();
                    InetAddress address = InetAddress.getByName(hostName);

                    System.out.println("Host Name: " + address.getHostName());
                    System.out.println("IP Address: " + address.getHostAddress());
                }

                else if (choice == 2) {
                    System.out.print("Enter IP Address: ");
                    String ip = in.readLine();
                    InetAddress address = InetAddress.getByName(ip);

                    System.out.println("IP Address: " + ip);
                    System.out.println("Host Name: " + address.getHostName());
                }

                else if (choice != 3) {
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                }

            } catch (IOException | NumberFormatException e) {
                System.out.println("Error: " + e.getMessage());
                choice = 0; 
            }

        } while (choice != 3);

        System.out.println("Program exited.");
    }
}

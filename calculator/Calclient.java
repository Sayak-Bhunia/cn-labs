import java.io.*;
import java.net.*;
import java.util.*;

public class Calclient {
    public static void main(String[] args) throws IOException {
        // Get the local host address
        InetAddress addr = InetAddress.getLocalHost();

        // Scanner to read user input
        Scanner inp = new Scanner(System.in);

        // Create a socket to connect to the server at port 6666
        Socket sock = new Socket(addr, 6666);

        // Input and output streams for communication
        DataInputStream inpStrm = new DataInputStream(sock.getInputStream());
        DataOutputStream outpStrm = new DataOutputStream(sock.getOutputStream());

        try {
            while (true) {
                // Display menu
                System.out.println("Type 1 for Addition");
                System.out.println("Type 2 for Subtraction");
                System.out.println("Type 3 for Multiplication");
                System.out.println("Type 4 for Division");
                System.out.println("Enter 0 to Exit");
                System.out.print("Enter your choice: ");
                
                // Read operation choice from user
                int oprtr = inp.nextInt();

                // Exit condition
                if (oprtr == 0) {
                    break;
                }

                // Send the chosen operation to server
                outpStrm.writeInt(oprtr);

                // Receive and display result from server
                String res = inpStrm.readUTF();
                System.out.println("Your Result for the given operation = " + res);
            }
        } catch (Exception exp) {
            System.out.println("An error occurred: " + exp.getMessage());
        } finally {
            // Cleanup resources
            inp.close();
            inpStrm.close();
            outpStrm.close();
            sock.close();
        }
    }
}

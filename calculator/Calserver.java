import java.io.*;
import java.net.*;
import java.util.*;

public class Calserver {
    public static void main(String[] args) throws IOException {
        // Create a server socket on port 6666
        ServerSocket server = new ServerSocket(6666);
        System.out.println("Server is running... Waiting for a client to connect...");

        // Accept a client connection
        Socket sock = server.accept();
        System.out.println("Client connected.");

        // Input and output streams
        DataInputStream inpStrm = new DataInputStream(sock.getInputStream());
        DataOutputStream outpStrm = new DataOutputStream(sock.getOutputStream());

        // Scanner for server-side input (currently used to enter operands manually)
        Scanner sc = new Scanner(System.in);

        try {
            while (true) {
                // Read operation choice from client
                int oprtr = inpStrm.readInt();
                System.out.println("Client has requested operation: " + oprtr);

                // Get operands from server-side input (NOTE: ideally, client should send these)
                System.out.print("Enter first number: ");
                int data1 = sc.nextInt();
                System.out.print("Enter second number: ");
                int data2 = sc.nextInt();

                int res = 0;
                switch (oprtr) {
                    case 1: // Addition
                        res = data1 + data2;
                        outpStrm.writeUTF(Integer.toString(res));
                        break;

                    case 2: // Subtraction
                        res = data1 - data2;
                        outpStrm.writeUTF(Integer.toString(res));
                        break;

                    case 3: // Multiplication
                        res = data1 * data2;
                        outpStrm.writeUTF(Integer.toString(res));
                        break;

                    case 4: // Division
                        if (data2 == 0) {
                            outpStrm.writeUTF("Error: Division by zero");
                        } else {
                            res = data1 / data2;
                            outpStrm.writeUTF(Integer.toString(res));
                        }
                        break;

                    default: // Invalid operation
                        outpStrm.writeUTF("You have given an invalid choice!");
                        break;
                }

                System.out.println("Result sent to the client...");
            }
        } catch (Exception exp) {
            System.out.println("An error occurred: " + exp.getMessage());
        } finally {
            // Cleanup resources
            sc.close();
            inpStrm.close();
            outpStrm.close();
            sock.close();
            server.close();
            System.out.println("Server shut down.");
        }
    }
}


C:\Users\student\Desktop\sayak>java Calserver
Server is running... Waiting for a client to connect...
Client connected.
Client has requested operation: 1
Enter first number: 5
Enter second number: 10
Result sent to the client...







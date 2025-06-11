import java.net.*;
import java.io.*;

class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(6666);
        System.out.println("Server is running. Waiting for client...");
        Socket s = ss.accept();
        System.out.println("Client connected.");
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        while (true) {
            int op = din.readInt();
            if (op == 0) break;

            int a = din.readInt();
            int b = din.readInt();
            int res;
            String response;

            switch (op) {
                case 1:
                    res = a + b;
                    response = "Result: " + res;
                    break;
                case 2:
                    res = a - b;
                    response = "Result: " + res;
                    break;
                case 3:
                    res = a * b;
                    response = "Result: " + res;
                    break;
                case 4:
                    if (b == 0) response = "Error: Division by zero";
                    else {
                        res = a / b;
                        response = "Result: " + res;
                    }
                    break;
                default:
                    response = "Invalid operation code!";
            }

            dout.writeUTF(response);
            System.out.println("Sent to client -> " + response); 
        }
        din.close();
        dout.close();
        s.close();
        ss.close();
        System.out.println("Server stopped.");
    }
}

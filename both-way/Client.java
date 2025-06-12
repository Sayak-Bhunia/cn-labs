import java.net.*;
import java.io.*;

class Client {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 6666);
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = "", s2 = "";
        while(!s1.equals("stop")) {
            System.out.println("Client = ");
            s2 = br.readLine();
            dout.writeUTF(s2);
            dout.flush();
            s2 = din.readUTF();
       	    System.out.println("Server = "+s2);
        }
        dout.close();
	din.close();
        s.close();
    }
}



C:\Users\Sayak\OneDrive\Desktop>java Client
Client =
hello
Server = stop
Client =
stop



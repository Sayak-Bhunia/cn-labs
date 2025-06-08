import java.net.*;
import java.io.*;

class MyServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(6666);
        Socket s = ss.accept();
        
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = "", str2 = "";
        
        while (!str.equals("stop")) {
            str = din.readUTF(); 
            System.out.println("Client says: " + str);

            System.out.print("Server: ");
            str2 = br.readLine();
            dout.writeUTF(str2); 
            dout.flush();
        }
        
        din.close();
        dout.close();
        s.close();
        ss.close();
    }
}


import java.net.*;
import java.io.*;

class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(6666);
        Socket s = ss.accept();
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = "", s2 = "";
        while(!s1.equals("stop")) {
            s1 = din.readUTF();
            System.out.println("Client = "+s1);
            System.out.println("Server = ");
            s2 = br.readLine();
            dout.writeUTF(s2);
            dout.flush();
        }
        din.close();
        dout.close();
        s.close();
        ss.close();
    }
}

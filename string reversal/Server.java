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
            s2 = rev(br.readLine());
            dout.writeUTF(s2);
            dout.flush();
        }
        din.close();
        s.close();
        ss.close();
    }
    public static String rev(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}


C:\Users\Sayak\OneDrive\Desktop>javac Server.java

C:\Users\Sayak\OneDrive\Desktop>java Server
Client = llaw eht revo spmuj xof eht
llaw eht revo spmuj xof eht


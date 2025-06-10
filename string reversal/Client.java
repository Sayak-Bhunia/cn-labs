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
            s1 = br.readLine();
            s2 = rev(s1);
            dout.writeUTF(s2);
            dout.flush();
            s1 = din.readUTF();
       	    System.out.println("Server = "+s1);
        }
        dout.close();
        s.close();
    }
    public static String rev(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}

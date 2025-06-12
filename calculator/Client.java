import java.net.*;
import java.io.*;
import java.util.*;

class Client {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 6666);
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1 -> +");
            System.out.println("2 -> -");
            System.out.println("3 -> *");
            System.out.println("4 -> /");
            System.out.println("0 -> Exit");
            int op = sc.nextInt();
            dout.writeInt(op);
            if(op == 0) break;
            int a = sc.nextInt();
            int b = sc.nextInt();
            dout.writeInt(a);
            dout.writeInt(b);
            String res = din.readUTF();
            System.out.println(res);
        }
        sc.close();
        din.close();
        dout.close();
        s.close();
    }
}



C:\Users\Sayak\OneDrive\Desktop>javac Client.java

C:\Users\Sayak\OneDrive\Desktop>javac Client.java

C:\Users\Sayak\OneDrive\Desktop>java Client
1 -> +
2 -> -
3 -> *
4 -> /
0 -> Exit
2
10
2
Result: 8
1 -> +
2 -> -
3 -> *
4 -> /
0 -> Exit
0

import java.net.InetAddress;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Username:");
	String username = scan.nextLine();
	try{
	    Socket cli = new Socket("192.168.70.245", 10430);
	    DataOutputStream cOut = new DataOutputStream(cli.getOutputStream());
            byte[] userjoined = (username+" has connected").getBytes();
            cOut.writeInt(userjoined.length);
            cOut.write(userjoined);
            cOut.flush();
            while(true){
            cli = new Socket("localhost", 10430);
            cOut = new DataOutputStream(cli.getOutputStream());
            System.out.println("Send Message");
            String x = scan.nextLine();
            byte[] mess = (username+": "+x).getBytes();
            cOut.writeInt(mess.length);
            cOut.write(mess);
            cOut.flush();
            }
        } catch (Exception ignored){};
    };
}

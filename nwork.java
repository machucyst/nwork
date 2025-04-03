import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;


public class nwork{
    public static void main(String[] args) {
        String host = "192.168.70.245";  // Bind to all available network interfaces
        int port = 10430;
        int index = 0;
        try (ServerSocket server = new ServerSocket(port, 50, InetAddress.getByName(host))) {
            System.out.println("Server Started on " + host + ":" + port);
            while (true) {
                Socket connection = server.accept();  // Wait for a client to connect

                try (DataInputStream serverIn = new DataInputStream(connection.getInputStream());
                     DataOutputStream serverOut = new DataOutputStream(connection.getOutputStream())) {

                    int length = serverIn.readInt();
                    if (length > 0) {;
                        byte[] messageIn = new byte[length];
                        serverIn.readFully(messageIn);
                        System.out.println(new String(messageIn));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

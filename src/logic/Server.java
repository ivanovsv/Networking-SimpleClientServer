package logic;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server accepting client on port 9999;
 * Server receives message from client and sends back acknowledgement.
 *
 * Created by IvanovsV on 01/07/2015.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9999);
        Socket clientConnection = server.accept();

        BufferedReader fromClient = new BufferedReader(new InputStreamReader(clientConnection.getInputStream()));
        PrintWriter toClient = new PrintWriter(clientConnection.getOutputStream(), true);
        String received;
        while ((received = fromClient.readLine()) != null) {
            System.out.println("CLIENT: " + received);
            toClient.println("SERVER RECEIVED MESSAGE: " + received + " TIME: " + System.currentTimeMillis());
            if (received.equals("bye")) {
                return;
            }
        }
    }
}

package logic;

import java.io.*;
import java.net.Socket;

/**
 * Creates a client connected to server on localhost on port 9999.
 * Client can switch off server with "bye" message.
 *
 * Created by IvanovsV
 */
public class Client {
    public static void main(String[] args) throws IOException {
        try(Socket client = new Socket("localhost", 9999);
            BufferedReader standardIn = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter toServer = new PrintWriter(client.getOutputStream(), true);
        ){
            String message = "";
            System.out.println("Enter messages for the server");
            while ((message = standardIn.readLine()) != null) {
                toServer.println(message);
                System.out.println(fromServer.readLine());
            }
        }
    }
}

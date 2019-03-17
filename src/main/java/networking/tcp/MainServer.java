package networking.tcp;

import java.io.IOException;
import java.net.ServerSocket;

public class MainServer {

    public static void main(String[] args) {
	    try(ServerSocket serverSocket = new ServerSocket(5000)) {
            while(true) {
                new EchoerServer(serverSocket.accept()).start();
            }


        } catch(IOException e) {
            System.out.println("Server exception " + e.getMessage());
        }
    }

}
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerInitializer {
    private static ArrayList<clientHandler> clientHandlers=new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(5000);
        Socket accept;
        while (true) {
            System.out.println("Server Start.waiting for client...");
            accept=serverSocket.accept();
            System.out.println("Client Connected Successfully..!");
            clientHandler clientThread=new clientHandler(accept, clientHandlers);
            clientHandlers.add(clientThread);
            clientThread.start();
        }
    }
}

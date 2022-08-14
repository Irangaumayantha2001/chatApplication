package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class clientHandler  extends Thread{
    private ArrayList<clientHandler> clientHandlers;
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public clientHandler(Socket socket,ArrayList<clientHandler> clientHandlers){

        try {
            this.socket=socket;
            this.clientHandlers=clientHandlers;
            this.reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.writer=new PrintWriter(socket.getOutputStream(),true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void run(){

        try {
            String msg;
            while ((msg = reader.readLine()) != null) {
                if (msg.equalsIgnoreCase( "exit")) {
                    break;
                }
                for (clientHandler cl : clientHandlers) {
                    cl.writer.println(msg);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
                writer.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}

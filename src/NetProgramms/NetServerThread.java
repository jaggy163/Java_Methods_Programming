package NetProgramms;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class NetServerThread {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8030);
            System.out.println("Initialized");
            while (true) {
                Socket socket = server.accept();
                System.out.println(socket.getInetAddress().getHostName() + " connected");
                ServerThread thread = new ServerThread(socket);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


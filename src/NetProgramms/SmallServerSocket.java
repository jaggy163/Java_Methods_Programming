package NetProgramms;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SmallServerSocket {
    public static void main(String[] args) {
        Socket s = null;
        PrintStream ps = null;
        try {
            ServerSocket server = new ServerSocket(8030); // Создание объекта и назначение номера порта
            s = server.accept(); // Ожидание соединения
            ps = new PrintStream(s.getOutputStream());
            ps.println("Привет!");
            ps.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (s != null) {
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

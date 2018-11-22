package NetProgramms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

public class ServerThread extends Thread {
    private PrintStream os; //Передача
    private BufferedReader is; //Прием
    private InetAddress addr; //адрес клиента

    public ServerThread(Socket s) throws IOException {
        os = new PrintStream(s.getOutputStream());
        is = new BufferedReader(new InputStreamReader(s.getInputStream()));
        addr = s.getInetAddress();
    }

    @Override
    public void run() {
        int i=0;
        String str;
        try {
            while ((str = is.readLine()) != null) {
                if("PING".equals(str)) {
                    os.println("PONG " +  ++i);
                }
                System.out.println("PING-PONG " + i + " with " + addr.getHostName());
            }
        } catch (IOException e) {
            System.err.println("Disconnect");;
        }
        finally {
            disconnect();
        }
    }

    public void disconnect() {
        try {
            if (os != null) {
                os.close();
            }
            if (is != null) {
                is.close();
            }
            System.out.println(addr.getHostName() + " disconnecting");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            this.interrupt();
        }
    }
}

package NetProgramms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.BufferPoolMXBean;
import java.net.Socket;

public class SmallClientSocket {
    public static void main(String[] args) {
        Socket s = null;
        BufferedReader br = null;
        try {
            s = new Socket("LAPTOP-033SVJ0K", 8030);
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String message = br.readLine();
            System.out.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (s != null) {
                    s.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

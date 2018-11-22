package NetProgramms;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MyIp {
    public static void main(String[] args) {
        InetAddress currintIp = null;
        try {
            currintIp = InetAddress.getLocalHost();
            System.out.println("Мой IP: " + currintIp.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}

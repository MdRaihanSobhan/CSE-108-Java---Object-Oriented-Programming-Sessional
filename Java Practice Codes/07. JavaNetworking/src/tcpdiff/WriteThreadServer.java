package tcpdiff;

import java.util.HashMap;
import java.util.Scanner;

import util.NetworkUtil;

public class WriteThreadServer implements Runnable {

    private Thread thr;
    String name;
    public HashMap<String, NetworkUtil> clientMap;

    public WriteThreadServer(HashMap<String, NetworkUtil> map, String name) {
        this.clientMap = map;
        this.name = name;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            Scanner input = new Scanner(System.in);
            while (true) {
                System.out.println("Enter the name of the client to send, a message to send: ");
                String[] s = input.nextLine().split(",");
                NetworkUtil networkUtil = clientMap.get(s[0]);
                if (networkUtil != null) {
                    networkUtil.write(name + ":" + s[1]);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}




package client;

import dto.GetListResponseMessage;
import dto.Message;
import util.NetworkUtil;

import java.io.IOException;

public class ReadThreadClient implements Runnable {
    private Thread thr;
    private NetworkUtil networkUtil;
    private ClientMenu clientMenu;

    public ReadThreadClient(NetworkUtil networkUtil, ClientMenu clientMenu) {
        this.networkUtil = networkUtil;
        this.thr = new Thread(this);
        this.clientMenu = clientMenu;
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = networkUtil.read();
                if (o instanceof String) {
                    // Login Response
                    String s = (String) o;
                    if (s.equals("success")) {
                        System.out.println("Login Successful");
                        clientMenu.setLoggedIn(true);
                    } else {
                        System.out.println("Login Unsuccessful");
                        clientMenu.setLoggedIn(false);
                    }
                }
                if (o instanceof GetListResponseMessage) {
                    // GetList Response
                    GetListResponseMessage obj = (GetListResponseMessage) o;
                    System.out.println("List of Connected Clients: ");
                    for (String clientName : obj.getClientList()) {
                        System.out.println(clientName);
                    }
                }
                if (o instanceof Message) {
                    // SendOne and Broadcast Response
                    Message obj = (Message) o;
                    System.out.println(obj.getFrom() + ", " + obj.getTo() + ", " + obj.getText());
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                networkUtil.closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}




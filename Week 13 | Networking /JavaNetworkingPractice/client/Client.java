package client;

import util.NetworkUtil;

public class Client {

    public Client(String serverAddress, int serverPort) {
        try {
            NetworkUtil networkUtil = new NetworkUtil(serverAddress, serverPort);
            new ClientMenu(networkUtil);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        String serverAddress = "127.0.0.1";
        int serverPort = 33333;
        Client client = new Client(serverAddress, serverPort);
    }
}



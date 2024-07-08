package server;

import sample.Club;
import sample.NetworkUtil;
import sample.homeMenuController;
import sample.welcomeToPlayerTransferController;


public class Client {
    private String clientName;
    private welcomeToPlayerTransferController login;
    private NetworkUtil networkUtil;
    private Club club;



    public Club getClub() {
        return club;
    }
    public void setClub(Club club) {
        this.club = club;
    }
    public String getClientName() {
        return clientName;
    }
    public NetworkUtil getNetworkUtil() {
        return networkUtil;
    }

    public welcomeToPlayerTransferController getLogin() {
        return login;
    }

    public Client(String serverAddress, int serverPort, String clientName, welcomeToPlayerTransferController logIn) {
        try {
            this.login=logIn;
            this.clientName=clientName;
            club= new Club(this);
            networkUtil = new NetworkUtil(serverAddress, serverPort);
            networkUtil.write(clientName);
            new ReadThreadClient(networkUtil, this);
        } catch (Exception e) {
            System.out.println(" Exception in ClientSocket" + e);
        }
    }
}
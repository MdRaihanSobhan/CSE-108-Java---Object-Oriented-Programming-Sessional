package server;

import javafx.application.Platform;
import sample.NetworkUtil;
import sample.Player;

import java.io.IOException;
import java.util.List;

public class ReadThreadClient implements Runnable {
    private Client client;
    private Thread thread;
    private NetworkUtil networkUtil;

    public ReadThreadClient(NetworkUtil networkUtil, Client client) {
        this.networkUtil = networkUtil;
        this.client=client;
        this.thread = new Thread(this);
        thread.start();
    }

    public void run() {
        try {
            while(true){
                Object o = networkUtil.read();
                if (o instanceof Message) {
                    Message obj = (Message) o;
                    String instruction = obj.getInstruction();
                    Player player = obj.getPlayer();
                    String instructionOfList = obj.getInstructionOfList();
                    List<Player> list = obj.getPlayerList();

                    if (instruction.equalsIgnoreCase("SuccessfullLogIn")) {
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    client.getLogin().showTransferHomeMenu();
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                            }
                        });
                    } else if (instruction.equalsIgnoreCase("UnSuccessfullLogIn")) {
                        System.out.println(" UnSuccessful log in from read thread");
                    } else if (instruction.equalsIgnoreCase("Clublogin")) {
                        client.getClub().addPlayer(player);
                    }


                    // Message obj = (Message) o;

                    else if (instructionOfList.equalsIgnoreCase("SaleListUpdated")) {
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    client.getClub().setPlayersToBuyList(list);
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                            }
                        });
                    }
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

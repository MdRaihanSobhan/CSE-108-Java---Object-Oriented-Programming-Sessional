package server;

import javafx.application.Platform;
import sample.NetworkUtil;
import sample.Player;

import java.io.IOException;
import java.util.Collection;

public class ReadThreadServer implements Runnable {
    private Thread thr;
    private NetworkUtil networkUtil;
    private Server server;


    public ReadThreadServer(NetworkUtil networkUtil, Server server) {
        this.networkUtil = networkUtil;
        this.server = server;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = networkUtil.read();
                if (o instanceof Message) {
                    Message obj = (Message) o;
                    String instruction = obj.getInstruction();
                    String client = obj.getClient();
                    Player player = obj.getPlayer();

                    if (instruction.equalsIgnoreCase("SaleRequest")) {
                        server.addToSellList(player);
                        Collection<NetworkUtil> clientmap = server.getClientMap().values();
                        for (NetworkUtil nu : clientmap) {
                            Message txt = new Message();
                            txt.setInstructionOfList("SaleListUpdated");
                            txt.setPlayerList(server.getPlayersToSellList());
                            try {
                                nu.write(txt);
                            } catch (Exception e) {
                                System.out.println(" Exception in writting to client server" + " e");
                            }
                        }
                    } else if (instruction.equalsIgnoreCase("BuyRequest")) {

                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    server.removeFromSellList(player, client);
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                            }
                        });


                        Collection<NetworkUtil> clientmap = server.getClientMap().values();
                        for (NetworkUtil nu : clientmap) {
                            Message txt = new Message();
                            txt.setInstructionOfList("SaleListUpdated");
                            txt.setPlayerList(server.getPlayersToSellList());
                            try {
                                nu.write(txt);
                            } catch (Exception e) {
                                System.out.println(" Exception in writting to client server for Buy Request " + " e");
                            }
                        }

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

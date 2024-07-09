package server;

import sample.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Message implements Serializable {
    private String instruction;
    private String client;
    private Player player;

    private String instructionOfList;
    private List<Player> list= new ArrayList<>();


    public Message() {
        client=null;
    }
    public String getInstruction() {
        return instruction;
    }
    public void setInstruction(String from) {
        this.instruction = from;
    }

    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player to) {
        this.player = to;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getClient() {
        return client;
    }




    public String getInstructionOfList() {
        return instructionOfList;
    }
    public void setInstructionOfList(String from) {
        this.instructionOfList = from;
    }

    public List<Player> getPlayerList() {
        return list;
    }
    public void setPlayerList(List<Player> list) {
        this.list = list;
    }
}
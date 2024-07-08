package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import server.Client;

import java.util.ArrayList;
import java.util.List;

public class Club {
    public List<Player> playerList; // player list of a club
    public List<Player> transferPlayerList;

    public List<Player> getTransferPlayerList() {
        return transferPlayerList;
    }

    public void setTransferPlayerList(List<Player> transferPlayerList) {
        this.transferPlayerList = transferPlayerList;
    }

    public String name;
    int NumberOfPlayers;

    public void setPlayersToBuyList(List<Player> playersToBuyList) {
        // playersToBuyList= new ArrayList<>();
        transferPlayerList = playersToBuyList;
        for(Player player: playersToBuyList){
            if(player.getClub().equalsIgnoreCase(name)){
            }
            else{
                playersToBuyList.add(player);
            }
        }
    }

    public Client client;

    public List<Player> playersToBuyList = new ArrayList<>(); // players that I can Buy

    public int getNumberOfPlayers() {
        return NumberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        NumberOfPlayers = numberOfPlayers;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public List<Player> getPlayersToBuyList() {
        return playersToBuyList;
    }

    public void setName(String name){

        this.name=name;
    }

    public String getName() {

        return name;
    }

    public void removeFromBuyablePlayer(Player player) {
        playersToBuyList.remove(player);
    }

    public void removePlayer(Player player) {
        playerList.remove(player);
    }
    public void addPlayer(Player player) {
        playerList.add(player);
    }

    // to get the age of maximum aged player of a club
    public int getMaxAge(){
        int MaxAge=0;
        for(Player player : playerList) {
            if (MaxAge < player.getAge())
                MaxAge = player.getAge();
        }

        return MaxAge;
    }

    // to get total salary of a club
    public static int getTotalYearlySalary(List<Player> playerList, String clubName){
        int TotalYearlySalary=0;
        for(Player player : playerList) {
            if(player.getClub().equalsIgnoreCase(clubName)){
                TotalYearlySalary += player.getSalary();
            }
        }
        return TotalYearlySalary*52 ;
    }

    // to get the salary of the player who gets maximum salary
    public double getMaxSalary(){
        double MaxSalary = 0;
        for(Player player : playerList)
            if(MaxSalary < player.getSalary())
                MaxSalary=player.getSalary();

        return MaxSalary;
    }

    // to get the height of a player which is maximum in the club
    public double getMaxHeight(){
        double MaxHeight = 0;
        for(Player player : playerList)
            if(MaxHeight < player.getHeight())
                MaxHeight=player.getHeight();

        return MaxHeight;
    }

    public Club(){
        this.playerList = new ArrayList();
        this.transferPlayerList= new ArrayList();
    }

    public Club(Client client) {
        this.client = client;
        this.name =client.getClientName();
        this.setNumberOfPlayers(0);
        this.playerList = new ArrayList();
        this.transferPlayerList= new ArrayList();
    }



    // to make a list of players of a club
    public static List<Club> setClubList(List<Player>playerList) throws Exception{
        List<Club>clubList = new ArrayList();

        for(Player player : playerList){
            boolean doesExist =false;
            for(Club club : clubList){
                if(club.name.equalsIgnoreCase(player.getClub())){
                    club.playerList.add(player);
                    doesExist=true;
                }
            }
            if(!doesExist){
                Club club= new Club();
                club.setName(player.getClub());
                club.playerList.add(player);
                clubList.add(club);
            }
        }

        return clubList;
    }

    public static ObservableList<NewPlayer> getMaxSalaryPlayer(List<Player> playerList, String name) throws Exception {
        double maxSalary = 0.0;
        ObservableList<NewPlayer> observableList;
        observableList= FXCollections.observableArrayList();

        for (Player player : playerList) {
            if (player.getClub().equalsIgnoreCase(name)) {
                if (player.getSalary() > maxSalary) {
                    maxSalary = player.getSalary();
                }
            }
        }

        for (Player player : playerList) {
            if (player.getClub().equalsIgnoreCase(name)) {
                if (player.getSalary() == maxSalary) {
                    observableList.add(new NewPlayer(player));
                }
            }
        }
        return observableList;

    }

    public static ObservableList<NewPlayer> getMaxHeightPlayer(List<Player> playerList, String name) throws Exception {
        double maxHeight = 0.0;
        ObservableList<NewPlayer> observableList;
        observableList= FXCollections.observableArrayList();

        for (Player player : playerList) {
            if (player.getClub().equalsIgnoreCase(name)) {
                if (player.getHeight() > maxHeight) {
                    maxHeight = player.getHeight();
                }
            }
        }

        for (Player player : playerList) {
            if (player.getClub().equalsIgnoreCase(name)) {
                if (player.getHeight()== maxHeight) {
                    observableList.add(new NewPlayer(player));
                }
            }
        }
        return observableList;

    }

    public static ObservableList<NewPlayer> getMaxAgePlayer(List<Player> playerList, String name) throws Exception {
        int maxAge = 0;
        ObservableList<NewPlayer> observableList;
        observableList= FXCollections.observableArrayList();

        for (Player player : playerList) {
            if (player.getClub().equalsIgnoreCase(name)) {
                if (player.getAge() > maxAge) {
                    maxAge = player.getAge();
                }
            }
        }

        for (Player player : playerList) {
            if (player.getClub().equalsIgnoreCase(name)) {
                if (player.getAge()== maxAge) {
                    observableList.add(new NewPlayer(player));
                }
            }
        }
        return observableList;

    }




}


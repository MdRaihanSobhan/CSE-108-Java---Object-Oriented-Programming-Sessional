package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.Scanner;

public class SearchPlayer {

    public static ObservableList<NewPlayer> searchByPlayerName(List<Player> playerList, String name) throws Exception {

        ObservableList<NewPlayer> observableList;
        observableList=  FXCollections.observableArrayList();

        for(Player player: playerList){
            if(player.getName().equalsIgnoreCase(name))
            {
                observableList.add(new NewPlayer(player));
            }
        }
        return observableList;
    }

    public static ObservableList<NewPlayer> showAllPlayers (List<Player> playerList, String name) throws Exception {

        ObservableList<NewPlayer> observableList;
        observableList = FXCollections.observableArrayList();

        for (Player player : playerList) {
            if(player.getClub().equalsIgnoreCase(name)){
                observableList.add(new NewPlayer(player));
            }
        }
        return observableList;
    }

    public static ObservableList<NewPlayer> searchByCountryName
            (List<Player> playerList, String clubName, String countryName) throws Exception {

        ObservableList<NewPlayer> observableList;
        observableList = FXCollections.observableArrayList();

        for (Player player: playerList){
            if(player.getClub().equalsIgnoreCase(clubName)){
                if(player.getCountry().equalsIgnoreCase(countryName)){
                    observableList.add(new NewPlayer(player));
                }
            }

        }
        return observableList;
    }

    public static ObservableList<NewPlayer> searchByPosition(List<Player> playerList,String clubName ,String positionName) throws Exception {

        ObservableList<NewPlayer> observableList;
        observableList = FXCollections.observableArrayList();

        for (Player player : playerList) {
            if(player.getClub().equalsIgnoreCase(clubName)) {
                if (player.getPosition().equalsIgnoreCase(positionName)) {
                    observableList.add(new NewPlayer(player));
                }
            }
        }
        return observableList;
    }

    public static ObservableList<NewPlayer> searchBySalaryRange
            (List<Player> playerList,String clubName, int lowerLimit, int upperLimit) throws Exception {

        ObservableList<NewPlayer> observableList;
        observableList = FXCollections.observableArrayList();

        for(Player player : playerList) {
            if (player.getClub().equalsIgnoreCase(clubName)) {
                if (player.getSalary() >= lowerLimit && player.getSalary() <= upperLimit) {
                    observableList.add(new NewPlayer(player));
                }
            }
        }
        return  observableList;
    }

    public static ObservableList<String> CountryWisePlayerCount
            (List<Country> countryList,List<Player> playerList, String clubName) throws Exception {

        ObservableList<String> observableList = FXCollections.observableArrayList();

        for(Player player : playerList) {
            if(player.getClub().equalsIgnoreCase(clubName)){
                for(Country country : countryList){
                    if(player.getCountry().equalsIgnoreCase(country.getName())){
                        country.increaseClubPlayerCount();
                    }
                }
            }
        }

        /*for(Country country : countryList){
            if(country.getClubPlayerCount()>0){
                String countryPlayerCountString = country.getName() + "  -------->  " + country.getClubPlayerCount() ;
                observableList.add(countryPlayerCountString);
            }
        }*/

        for(Country country : countryList){
            if(country.getClubPlayerCount()>0){
               // String countryPlayerCountString = country.getName() + "   has   " + country.getClubPlayerCount()  + "  player(s) ";
                String countryCount;
                if(country.getClubPlayerCount()!=1) {
                    countryCount = country.getClubPlayerCount() + "  players  are  from  " + country.getName();
                }
                else{
                    countryCount = country.getClubPlayerCount() + "  player  is  from  " + country.getName();
                }

                //observableList.add(countryPlayerCountString);
                observableList.add(countryCount);
            }
        }
        return observableList;
    }

}

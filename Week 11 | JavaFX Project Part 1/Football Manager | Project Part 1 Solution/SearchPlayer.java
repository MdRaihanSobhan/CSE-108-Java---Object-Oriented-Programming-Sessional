import java.util.List;
import java.util.Scanner;

public class SearchPlayer {
    // 4 types of search-> By Player Name
    public static void searchByPlayerName(List<Player> playerList) throws Exception {
        System.out.println("Enter Name of the Player: ");
        boolean doesMatch = false;
        Scanner cin =new Scanner(System.in);
        String name= cin.nextLine();
        for(Player player: playerList){
            if(name.equalsIgnoreCase(player.getName()))
            {
                player.displayPlayerinfo();
                doesMatch=true;
            }
        }
        if(!doesMatch)
            System.out.println("No such player with this name");
        cin.nextLine();
        Server.searchPlayers();
    }

    public static void searchByClubAndCountry(List<Country> countryList) throws Exception {
        boolean doesMatch= false;
        Scanner cin =new Scanner(System.in);
        System.out.println("Enter name of the Country: ");
        String country= cin.nextLine();
        System.out.println("Enter name of the Club: ");
        String club= cin.nextLine();

        for(Country countrytemp : countryList){
            if(country.equalsIgnoreCase(countrytemp.getName()))
            {
                if(club.equalsIgnoreCase("ANY"))
                {
                    // System.out.println("Player(s) of " + countrytemp.getName() + " in any club");
                    // players from any club of a country
                    for(Player player : countrytemp.playerList)
                        player.displayPlayerinfo();
                    doesMatch=true;
                }
                else
                {
                    for(Player player : countrytemp.playerList)
                        if(club.equalsIgnoreCase(player.getClub())) {
                            doesMatch=true;
                            player.displayPlayerinfo();
                        }
                }
            }
        }
        if(!doesMatch)
            System.out.println("No such player with this country and club");
        cin.nextLine();
        Server.searchPlayers();
    }


    public static void searchByPosition(List<Player> playerList) throws Exception {
        System.out.println("Enter Position of the Player :");
        boolean doesMatch= false;
        Scanner cin =new Scanner(System.in);
        String position= cin.nextLine();

        for(Player player : playerList){
            if(player.getPosition().equalsIgnoreCase(position)){
                player.displayPlayerinfo();
                doesMatch=true;
            }
        }
        if(!doesMatch)
            System.out.println("No such player with this position");
        cin.nextLine();
        Server.searchPlayers();
    }

    public static void searchBySalaryRange(List<Player> playerList) throws Exception {
        System.out.println("Enter Lower Limit :");
        boolean doesMatch= false;
        Scanner cin =new Scanner(System.in);
        int lowerLimit= cin.nextInt();
        System.out.println("Enter Upper Limit :");
        int upperLimit= cin.nextInt();
        for(Player player : playerList){
            if(player.getSalary()>=lowerLimit && player.getSalary()<=upperLimit ){
                player.displayPlayerinfo();
                doesMatch=true;
            }
        }
        if(!doesMatch)
            System.out.println("No such player with this weekly salary range");

        cin.nextLine();
        Server.searchPlayers();
    }



    public static void CountryWisePlayerCount(List<Country> countryList) throws Exception {
        Scanner cin =new Scanner(System.in);
        for (Country country : countryList)
            System.out.println(country.name + " has " + country.playerList.size() + " player(s).");

        cin.nextLine();
        Server.searchPlayers();
    }
}

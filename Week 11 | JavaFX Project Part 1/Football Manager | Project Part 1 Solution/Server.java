import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server {
    private static final String INPUT_FILE_NAME = "players.txt";

    static List<Player> playerList = new ArrayList();
    static List<Club> clubList = new ArrayList<>();
    static List<Country> countryList= new ArrayList<>();

    Server() throws Exception {
        playerList = readFromFile();
    }

    public static List<Player> readFromFile() throws Exception {
        List<Player> playerList = new ArrayList();

        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));

        while (true) {
            String line = br.readLine();
            if (line == null) break;
            String[] tokens = line.split(",");
            Player player = new Player();
            player.setName(tokens[0]);
            player.setCountry(tokens[1]);
            player.setAge(Integer.parseInt(tokens[2]));
            player.setHeight(Double.parseDouble(tokens[3]));
            player.setClub(tokens[4]);
            player.setPosition(tokens[5]);
            player.setNumber(Integer.parseInt(tokens[6]));
            player.setSalary(Double.parseDouble(tokens[7]));

            playerList.add(player);
        }
        br.close();

        return playerList;
    }

    public static void writeToFile(List<Player> playerList) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(INPUT_FILE_NAME));
        for (Player player : playerList) {
            bw.write(String.valueOf(player));
            bw.write("\n");
        }
        bw.close();
    }

    public static void addPlayer() throws Exception {
        Scanner cin = new Scanner(System.in);
        Player player = new Player();
        player.takePlayer(cin);
    }



    public static void mainMenu() throws Exception {
        System.out.println("Main Menu:");
        System.out.println("(1) Search Players");
        System.out.println("(2) Search Clubs");
        System.out.println("(3) Add Player");
        System.out.println("(4) Exit System");
        System.out.println();
        System.out.println("Enter your desired option : ");

        Scanner cin = new Scanner(System.in);

        int option = cin.nextInt();

        if(option==1)
            searchPlayers();
        else if(option==2)
            searchClubs();
        else if(option==3)
            addPlayer();
        else if(option==4) {
            Server.writeToFile(Server.playerList);
            System.exit(1);
        }
        else {
            System.out.println("Please enter an integer between 1 and 4");
            mainMenu();
        }
    }

    public static void searchPlayers() throws Exception {
        System.out.println("Player Searching Options:");
        System.out.println("(1) By Player Name");
        System.out.println("(2) By Club and Country");
        System.out.println("(3) By Position");
        System.out.println("(4) By Salary Range");
        System.out.println("(5) Country-wise player count");
        System.out.println("(6) Back to Main Menu");
        System.out.println();
        System.out.println("Enter your desired option : ");
        Scanner cin = new Scanner(System.in);

        int option= cin.nextInt();

        if(option==1)
            SearchPlayer.searchByPlayerName(readFromFile());
        else if(option==2)
            SearchPlayer.searchByClubAndCountry(Country.setCountryList(readFromFile()));
        else if(option==3)
            SearchPlayer.searchByPosition(readFromFile());
        else if(option==4)
            SearchPlayer.searchBySalaryRange(readFromFile());
        else if(option==5)
            SearchPlayer.CountryWisePlayerCount(Country.setCountryList(readFromFile()));
        else if(option==6)
            mainMenu();
        else {
            System.out.println("Please enter an integer between 1 and 6");
            searchPlayers();
        }
    }

    public static void searchClubs() throws Exception {
        System.out.println("Club Searching Options:");
        System.out.println("(1) Player(s) with the maximum salary of a club");
        System.out.println("(2) Player(s) with the maximum age of a club");
        System.out.println("(3) Player(s) with the maximum height of a club");
        System.out.println("(4) Total yearly salary of a club");
        System.out.println("(5) Back to Main Menu");
        System.out.println();
        System.out.println("Enter your desired option : ");
        Scanner cin =new Scanner(System.in);

        int option= cin.nextInt();

        if(option==1)
            SearchClub.PlayersWithMaxSalary(Club.setClubList(readFromFile()));
        else if(option==2)
            SearchClub.PlayersWithMaxAge(Club.setClubList(readFromFile()));
        else if(option==3)
            SearchClub.PlayersWithMaxHeight(Club.setClubList(readFromFile()));
        else if(option==4)
            SearchClub.totalYearlySalary(Club.setClubList(readFromFile()));
        else if(option==5)
            mainMenu();
        else {
            System.out.println("Please enter an integer between 1 and 5");
            searchClubs();
        }
    }




}

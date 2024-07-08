import java.util.List;
import java.util.Scanner;

public class SearchClub {


    public static void PlayersWithMaxSalary(List<Club>clubList) throws Exception {
        System.out.println("Enter Name of the Club: ");
        Scanner cin =new Scanner(System.in);
        String clubName= cin.nextLine();
        boolean doesMatch= false;
        for(Club club : clubList) {
            if (clubName.equalsIgnoreCase(club.getName())) {
                doesMatch=true;
                for (Player player : club.playerList)
                    if (player.getSalary() == club.getMaxSalary())
                        player.displayPlayerinfo();
            }
        }

        if(!doesMatch)
            System.out.println("No such club with this name");
        cin.nextLine();
        Server.searchClubs();
    }

    public static void PlayersWithMaxAge(List<Club>clubList) throws Exception {
        System.out.println("Enter Name of the Club: ");
        Scanner cin =new Scanner(System.in);
        String clubName= cin.nextLine();
        boolean doesMatch= false;
        for(Club club : clubList) {
            if (clubName.equalsIgnoreCase(club.getName())) {
                doesMatch=true;
                for (Player player : club.playerList)
                    if (player.getAge() == club.getMaxAge())
                        player.displayPlayerinfo();
            }
        }

        if(!doesMatch)
            System.out.println("No such club with this name");
        cin.nextLine();
        Server.searchClubs();
    }

    public static void PlayersWithMaxHeight(List<Club>clubList) throws Exception {
        System.out.println("Enter Club Name: ");
        Scanner cin =new Scanner(System.in);
        String clubName= cin.nextLine();
        boolean doesMatch= false;
        for(Club club : clubList) {
            if (clubName.equalsIgnoreCase(club.getName())) {
                doesMatch=true;
                for (Player player : club.playerList)
                    if (player.getHeight() == club.getMaxHeight())
                        player.displayPlayerinfo();
            }
        }

        if(!doesMatch)
            System.out.println("No such club with this name");
        cin.nextLine();
        Server.searchClubs();
    }

    public static void totalYearlySalary(List<Club>clubList) throws Exception {
        System.out.println("Enter Club Name: ");
        Scanner cin =new Scanner(System.in);
        String clubName= cin.nextLine();
        boolean doesMatch= false;
        for(Club club : clubList) {
            if (club.getName().equalsIgnoreCase(clubName)) {
                doesMatch=true;
                System.out.println("Total Yearly Salary of " + clubName + " is " + club.getTotalYearlySalary());
            }
        }
        if(!doesMatch)
            System.out.println("No such club with this name");
        cin.nextLine();
        Server.searchClubs();
    }
}

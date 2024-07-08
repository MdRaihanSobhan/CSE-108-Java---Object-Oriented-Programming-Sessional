import java.util.ArrayList;
import java.util.List;

public class Club {

    public List<Player> playerList = new ArrayList(); // player list of a club

    public String name;

    public void setName(String name){

        this.name=name;
    }

    public String getName() {

        return name;
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
    public int getTotalYearlySalary(){
        int TotalYearlySalary=0;
        for(Player player : playerList) {
            TotalYearlySalary+= player.getSalary();
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


}

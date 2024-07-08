import java.util.Random;
import java.util.Scanner;

public class Main {
    // Tasks: Read the given files thoroughly and follow the comments
    // Write new classes, their member variables and methods following object-oriented approach, if required
    // You do not need to handle bound checking and corner cases
    // Check a sample input-output at the end of this file
    public static void main(String[] args) {
        int clubCount;
        int leagueCount;
        // take clubCount and leagueCount as input
        Scanner cin = new Scanner(System.in);
        clubCount= cin.nextInt();
        leagueCount= cin.nextInt();
        Club c[] = new Club[clubCount];
        for (int i = 0; i < clubCount; i++) {
            c[i] = new Club();
            c[i].setId(i + 1);
            String clubName;
            // take clubName as input
            clubName= cin.next();
            c[i].setName(clubName);
        }
        League l[] = new League[leagueCount];
        for (int i = 0; i < leagueCount; i++) {
            l[i] = new League();
            String leagueName;
            // take leagueName as input
            leagueName= cin.next();
            l[i].setName(leagueName);
        }

        for (int i=0; i<clubCount; i++){
            l[i%leagueCount].addClub(c[i]);
        }

        for (int i = 0; i < leagueCount; i++) {
            l[i].printLeagueInfo();
            l[i].scheduleMatches();
            l[i].simulateMatches();
            l[i].printMatches();
            l[i].showStandings();
            l[i].printLeagueInfo();
        }


        int leagueIndex = 0;
        int clubIndex = 0;
        // club and league indexes may be changed during evaluation
        // you can take it as input or leave it as it is (optional)

        l[leagueIndex].removeClub(c[clubIndex]);
        l[leagueIndex].printLeagueInfo();
        l[leagueIndex].scheduleMatches();
        l[leagueIndex].simulateMatches();
        l[leagueIndex].printMatches();
        l[leagueIndex].showStandings();
        l[leagueIndex].printLeagueInfo();
    }
}
/*
Sample Input - clubCount = 7, leagueCount = 2, clubName = "C1", "C2", "C3" etc., leagueName = "L1", "L2"
Sample Output -
League : L1
Clubs:
C1
C3
C5
C7
Matches:
C1 wins. C1 7-3 C3
C1 wins. C1 3-0 C5
C7 wins. C1 5-9 C7
C3 wins. C3 8-6 C1
C3 wins. C3 3-1 C5
C7 wins. C3 1-5 C7
Match drawn. C5 4-4 C1
C3 wins. C5 0-4 C3
C5 wins. C5 4-2 C7
C7 wins. C7 7-5 C1
Match drawn. C7 0-0 C3
C7 wins. C7 7-5 C5
Sl. - Club - Points
1. C7 9
2. C3 7
3. C1 5
4. C5 3
League : L1
Clubs:
C1
C3
C5
C7
League : L2
Clubs:
C2
C4
C6
Matches:
C2 wins. C2 5-1 C4
C2 wins. C2 7-2 C6
C2 wins. C4 0-8 C2
C4 wins. C4 1-0 C6
C6 wins. C6 8-4 C2
C6 wins. C6 6-4 C4
Sl. - Club - Points
1. C2 6
2. C6 4
3. C4 2
League : L2
Clubs:
C2
C4
C6
League : L1
Clubs:
C3
C5
C7
Matches:
C5 wins. C3 7-9 C5
C3 wins. C3 8-5 C7
C3 wins. C5 4-6 C3
C7 wins. C5 8-9 C7
C7 wins. C7 1-0 C3
C5 wins. C7 6-8 C5
Sl. - Club - Points
1. C3 4
2. C5 4
3. C7 4
League : L1
Clubs:
C3
C5
C7
*/
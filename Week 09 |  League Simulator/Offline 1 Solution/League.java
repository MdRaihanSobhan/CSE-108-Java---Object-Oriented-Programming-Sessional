public class League {
    private Match[] matches;
    private int matchCount;
    private int clubCount;
    // add your variables here, if required
    private String name= new String();
    private Club[] clubtable;

    public League() {
        // assume a league can have at most 5 clubs, add code for initialization accordingly
        clubtable= new Club[5];
        clubCount = 0;
        matchCount = 0;
    }

    public void printLeagueInfo(){
        System.out.println("League : " + name);
        printClubs();
    }

    public void printClubs(){
        System.out.println("Clubs:");
        // print the name of the clubs of this league, each one on a line
        for(int i=0;i<clubCount;i++){
            System.out.println(clubtable[i].getName());
        }
    }

    public void scheduleMatches(){
        matchCount = (clubCount*(clubCount-1));   // nC2 * 2 (home and away)
        matches = new Match[matchCount];
        int matchNo = 0;
        for (int i=0; i<clubCount; i++){
            for (int j=0; j<clubCount; j++){
                if(i==j) // a team can't play with itself
                    continue;
                // check the constructor of the Match class and add your code here
                // note that there will be two matches between club A and club B
                // in the first match, club A will play as the home team and in the second match, as the away team
                matches[matchNo]= new Match(matchNo+1, clubtable[i], clubtable[j]);
                matchNo++;
            }
        }
    }

    public void simulateMatches(){
        for(int i=0;i<clubCount;i++) {
            clubtable[i].resetpoint();
        }
        for (int i=0; i<matchCount; i++){
            matches[i].play();
        }
    }

    public void showStandings(){
        // sort the clubs in descending order of points
        // note that, the sequence in which clubs were added to the league, should be unchanged
        // check the given sample output for clarification
        // (carefully observe the output of showStandings() followed by printLeagueInfo() method calls
        // you can use additional arrays if needed
        Club[] standings= new Club[clubCount];

        for(int i=0;i<clubCount;i++){
            standings[i]= clubtable[i];
        }

        System.out.println("Sl. - Club - Points");

        for(int i=0;i+1 <clubCount;i++) {
            for (int j = 0; j < clubCount - i - 1; j++) {
                if (standings[j].getPoints() < standings[j + 1].getPoints()) {
                    Club t = standings[j];
                    standings[j] = standings[j + 1];
                    standings[j + 1] = t;
                }
            }
        }
        // print the clubs in descending order of points
        for(int i=0;i<clubCount;i++){
            System.out.println((i+1)+". "+standings[i].getName()+" "+standings[i].getPoints());
        }
    }

    // add your methods here, if required

    public void printMatches(){
        System.out.println("Matches:");
        matchCount = (clubCount*(clubCount-1));
        for(int i=0;i<matchCount;i++){
            matches[i].showResult();
        }
    }

    public void removeClub(Club aclub) {
        int index = -1;
        for (int i = 0; i < clubCount; i++) {
            if (clubtable[i].getId() == aclub.getId() && clubtable[i].getName() == aclub.getName()) {
                index = i;
            }
        }
        if (index != -1) {
            for (int i = index; i < clubCount - 1; i++) {
                clubtable[i] = clubtable[i + 1];
            }

            clubCount--;
        }
    }

    public void setName(String temp){
        this.name= temp;
    }

    public void addClub(Club temp){
        clubtable[clubCount]= temp;
        clubCount++;
    }
}


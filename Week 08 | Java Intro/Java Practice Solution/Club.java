public class Club {
    private int id;
    private String name;
    private Player[] players;
    int playerCount = 0;
    //players = new Player[20];
    // add your code here
    public Club() {
        this.players = new Player[11];
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName (String name) {
        this.name = name;
    }
    public void addPlayer (Player p) {
        players[playerCount] = p;
        playerCount++;
    }
    int getId () {
        return id;
    }
    public String getName () {
        return name;
    }
    Player getMaxSalaryPlayer () {
        Player p = players[0];
        double maxSalary = players[0].getSalary();
        for (int i = 0; i < playerCount; i++) {
            if (maxSalary <= players[i].getSalary()) {
                maxSalary = players[i].getSalary();
                p = players[i];
            }
        }
        return p;
    }
    // you are not allowed to write any other constructor

    public double getSalary() {
        double total = 0;
        for (int i = 0; i < playerCount; i++) {
            total += players[i].getSalary();
        }
        return total;
    }

    // add your code here
}
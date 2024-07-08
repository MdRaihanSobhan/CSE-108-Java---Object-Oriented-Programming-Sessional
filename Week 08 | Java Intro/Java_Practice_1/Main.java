import java.util.Random;

// you are not allowed to change the main function

public class Main {
    public static void main(String[] args) {
        Player p[] = new Player[5];
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            p[i] = new Player(i + 1, "P" + (i + 1));
            p[i].setSalary(10000 * r.nextDouble());
        }
        Club c[] = new Club[2];
        for (int i = 0; i < 2; i++) {
            c[i] = new Club();
            c[i].setId(i + 1);
            c[i].setName("C" + (i + 1));
        }
        c[0].addPlayer(p[0]); // add the player to this club
        c[1].addPlayer(p[1]); // add the player to this club
        c[0].addPlayer(p[2]); // add the player to this club
        c[1].addPlayer(p[3]); // add the player to this club
        c[0].addPlayer(p[4]); // add the player to this club
        for (int i = 0; i < 2; i++) {
            System.out.println(c[i].getId() + ", " + c[i].getName());
            System.out.println(c[i].getSalary()); // prints the total salary for this club
            System.out.println(c[i].getMaxSalaryPlayer().getName()); // prints the name of the player with highest salary in this club
        }
    }
}

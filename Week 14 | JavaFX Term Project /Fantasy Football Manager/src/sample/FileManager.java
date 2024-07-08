package sample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private static final String INPUT_FILE_NAME = "players.txt";
    private static final String OUTPUT_FILE_NAME = "players.txt";
    public static List<Player> playerList = new ArrayList();

    FileManager() throws Exception {
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
        BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));

        for (Player player : playerList) {
            bw.write(player.getName() + "," + player.getCountry() + "," + player.getAge()+ "," + player.getHeight()+ "," +
                    player.getClub()+ "," + player.getPosition() + "," + player.getNumber() + "," + player.getSalary() );
            bw.write("\n");
        }
        bw.close();
    }
}

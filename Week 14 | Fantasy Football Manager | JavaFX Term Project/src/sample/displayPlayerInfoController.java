package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import server.Client;
import server.Message;

public class displayPlayerInfoController {

    private Player player;
    private int flag;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    private showTransferController transferHome;
    public void setTransferHome(showTransferController transferHome) {
        this.transferHome = transferHome;
        flag=0;
    }

    @FXML
    private Text nameOfPlayer;

    @FXML
    private Text countryOfPlayer;

    @FXML
    private Text ageOfPlayer;

    @FXML
    private Text salaryOfPlayer;

    @FXML
    private Text positionOfPlayer;

    @FXML
    private Text heightOfPlayer;

    @FXML
    private Text numberOfPlayer;

    @FXML
    private Button actionButton;


    public void setToBuy(Player player) {

        flag = 1;
        actionButton.setText("Buy");
        actionButton.setVisible(true);

        this.player = player;
        String s;
        nameOfPlayer.setText("Name : " + player.getName());
        countryOfPlayer.setText("Country : " + player.getCountry());
        s = ""+ player.getAge();
        ageOfPlayer.setText("Age : " + s);
        s = ""+ player.getHeight();
        heightOfPlayer.setText("Height : " + s);
        positionOfPlayer.setText("Position : " + player.getPosition());
        s = ""+ player.getNumber();
        numberOfPlayer.setText("Number : " + s);
        s = ""+ player.getSalary();
        salaryOfPlayer.setText("Salary : " + s);

    }

    public void setToSell(Player player) {


        flag=2;
        actionButton.setText("Sell");
        actionButton.setVisible(true);
        System.out.println("New Problem 1");

        this.player = player;
        String s= " " ;
        nameOfPlayer.setText("Name : " + player.getName());
        countryOfPlayer.setText("Country : " + player.getCountry());
        s = ""+ player.getAge();
        ageOfPlayer.setText("Age : " + s);
        s = ""+player.getHeight();
        heightOfPlayer.setText("Height : " + s);
        positionOfPlayer.setText("Position : " + player.getPosition());
        s = ""+player.getNumber();
        numberOfPlayer.setText("Number : " + s);
        s = ""+player.getSalary();
        salaryOfPlayer.setText("Salary : " + s);

    }


    @FXML
    void action(ActionEvent event) throws Exception{

        if(this.getFlag()==2){
            transferHome.getClient().getClub().removePlayer(player);
            NetworkUtil nu = transferHome.getClient().getNetworkUtil();
            Message txt= new Message();
            txt.setInstruction("SaleRequest");
            txt.setPlayer(player);
            try{
                nu.write(txt);
            }catch(Exception e){
                System.out.println("Exception in writing to server , in ShowPlayer ,transfer sale " + e);
            }
            transferHome.sellPlayerAction(event);
        }
        else if(this.getFlag()==1){
            Player newPlayer= new Player(player, transferHome.getClient().getClientName());
            transferHome.getClient().getClub().removeFromBuyablePlayer(player);
            transferHome.getClient().getClub().addPlayer(newPlayer);
            NetworkUtil nu = transferHome.getClient().getNetworkUtil();
            Message txt= new Message();
            txt.setInstruction("BuyRequest");
            txt.setClient(transferHome.getClient().getClientName());
            txt.setPlayer(player);
            System.out.println(player.getClub() + newPlayer.getClub());
            try{
                nu.write(txt);
            }catch(Exception e){
                System.out.println("Exception in writing to server , in ShowPlayer ,transfer sale " + e);
            }
            transferHome.buyPlayerAction(event);
        }


    }

}
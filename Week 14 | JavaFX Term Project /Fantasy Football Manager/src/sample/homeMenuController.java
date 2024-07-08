package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class homeMenuController implements Initializable {

    public static int clubNumber ;

    private Main main;
    private Stage homeStage;

    public void setMain(Main main) {
        this.main = main;
    }

    public Main getMain(Main main) {
        return main;
    }

    public void setHomeStage(Stage homeStage) {
        this.homeStage = homeStage;
    }

    public static int getClubNumber() {
        return clubNumber;
    }

    public static void setClubNumber(int clubNumber) {
        searchPlayersController.clubNumber = clubNumber;
    }

    public FileManager objectOfFile = new FileManager();
    public List<Player> playerList = FileManager.playerList;

    public homeMenuController() throws Exception{

    }














    @FXML
    private Button allPlayersButton;

    @FXML
    private Button searchPlayerButton;

    @FXML
    private Button countryWiseButton;

    @FXML
    private Button totalSalaryButton;

    @FXML
    private Button transferButton;

    @FXML
    private Button logoutButton;

    @FXML
    private Button homeNavButton;

    @FXML
    private Button searchNavButton;

    @FXML
    private Button transferNavButton;

    @FXML
    private ImageView clubLogoView;

    @FXML
    private Label clubName;

    @FXML
    void GoToSearch(ActionEvent event) throws Exception {
        System.out.println(" SearchPlayers Button Pressed ");
        try {
            main.showSearchPlayerMenu();
        }catch (Exception e){
            System.out.println("Exception in HomeMenu ,Search Players Button" );
        }
    }

    @FXML
    void GoToTransfer(ActionEvent event) {

        System.out.println("Player Transfer  Activated");
        showTransferController.mainObject = getMain(main);

        try {
            main.showTransferMenu();
        } catch (Exception e) {
            System.out.println(" Exception in Home Menu, Trasnfer Button " + e);
        }
    }

    @FXML
    void logout(ActionEvent event) {
        System.out.println(" Logout Button Pressed ");
        try {
            main.showLoginMenu();
        } catch (Exception e) {
            System.out.println(" Exception in Home Menu, Logout Button " + e);
        }
    }

    @FXML
    void showAllPlayers(ActionEvent event) {
        showPlayerListController.playerState = 1 ;
        System.out.println("State set to 1 ");

        System.out.println(" Show CLub Players Activated ");
        try {
            main.showPlayersMenu();
        }catch (Exception e){
            System.out.println("Exception in HomeMenu ,Players Button");
        }
    }

    @FXML
    void showCountryWisePlayerCount(ActionEvent event) {
        System.out.println(" Show COuntry Wise Player Count Activated");
        try {
            main.showCountryWisePlayerCountMenu();
        } catch (Exception e) {
            System.out.println(" Exception in Home Menu, Show Nation Wise Player Count Button " + e);
        }
    }

    @FXML
    void showTotalSalary(ActionEvent event) {
        System.out.println(" Show Total Salary Activated");
        try {
            main.showTotalSalaryMenu();
        } catch (Exception e) {
            System.out.println(" Exception in Home Menu, ShowTotalSalary Button " + e);
        }
    }

    public void setClubName(String name) {
        clubName.setText(name);
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {

        if(clubNumber == 1){
            clubName.setText("CHELSEA");
            clubLogoView.setImage(new Image(getClass().getResourceAsStream("chelsea.png")));
        }
        else if(clubNumber == 2){
            clubName.setText("MANCHESTER UNITED");
            clubLogoView.setImage(new Image(getClass().getResourceAsStream("manutd.png")));
        }
        else if(clubNumber == 3){
            clubName.setText("MANCHESTER CITY");
            clubLogoView.setImage(new Image(getClass().getResourceAsStream("mancity2.png")));
        }
        else if(clubNumber == 4){
            clubName.setText("LIVERPOOL");
            clubLogoView.setImage(new Image(getClass().getResourceAsStream("liverpool.png")));
        }
        else if(clubNumber == 5){
            clubName.setText("ARSENAL");
           clubLogoView.setImage(new Image(getClass().getResourceAsStream("arsenal.png")));
        }
    }



}

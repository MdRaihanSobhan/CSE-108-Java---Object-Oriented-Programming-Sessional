package sample;

import javafx.stage.Stage;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class showCountryWisePlayerCountController implements Initializable {
    public static int clubNumber = 0 ;
    private Stage stage;
    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }
    public showCountryWisePlayerCountController () throws Exception{

    }

    public Main getMain(Main main) {
        return main;
    }

    public FileManager objectOfFile = new FileManager();
    public List<Player> playerList = FileManager.playerList;
    public List<Country> countryList = Country.setCountryList(playerList);

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public static int getClubNumber() {
        return clubNumber;
    }

    public static void setClubNumber(int clubNumber) {
        showCountryWisePlayerCountController.clubNumber = clubNumber;
    }


    @FXML
    private ImageView clubLogoImageView;

    @FXML
    private Label clubName;

    @FXML
    private Button backButton;

    @FXML
    private Button logOutButton;

    @FXML
    private ListView<String> countryWisePlayerCountListField;

    @FXML
    private Button showResultButton;

    @FXML
    private Button homeNavButton;

    @FXML
    private Button searchNavButton;

    @FXML
    private Button transferNavButton;

    @FXML
    void GoBackToSearch(ActionEvent event) {
        System.out.println(" Button Pressed ");

        try {
            main.showSearchPlayerMenu();
        }catch (Exception e){
            System.out.println(" Exception in Show Nation Wise Player Count Menu, SearchPlayer Nav Button " + e);
        }
    }

    @FXML
    void GoToHome(ActionEvent event) {
        System.out.println(" Home Navigation Button has been Pressed ");

        try {
            main.showHomeMenu();
        }catch (Exception e){
            System.out.println(" Exception in Show Nation Wise Player Count , Home Nav Button " + e);
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
        System.out.println(" Logout Button has been Pressed ");

        try {
            main.showLoginMenu();
        } catch (Exception e) {
            System.out.println(" Exception in Show Nation Wise Player Count, Logout Button " + e);
        }
    }

    @FXML
    void showResult(ActionEvent event) throws Exception{
        ObservableList<String> observableList = SearchPlayer.CountryWisePlayerCount(countryList,playerList,clubName.getText());
        countryWisePlayerCountListField.setItems(observableList);

        for(Player player : playerList) {
            if(player.getClub().equalsIgnoreCase(clubName.getText())){
                for(Country country : countryList){
                    if(player.getCountry().equalsIgnoreCase(country.getName())){
                        country.setClubPlayerCount(0);
                    }
                }
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(clubNumber == 1){
            clubName.setText("CHELSEA");
            clubLogoImageView.setImage(new Image(getClass().getResourceAsStream("chelsea.png")));
        }
        else if(clubNumber == 2){
            clubName.setText("MANCHESTER UNITED");
            clubLogoImageView.setImage(new Image(getClass().getResourceAsStream("manutd.png")));
        }
        else if(clubNumber == 3){
            clubName.setText("MANCHESTER CITY");
            clubLogoImageView.setImage(new Image(getClass().getResourceAsStream("mancity2.png")));
        }
        else if(clubNumber == 4){
            clubName.setText("LIVERPOOL");
            clubLogoImageView.setImage(new Image(getClass().getResourceAsStream("liverpool.png")));
        }
        else if(clubNumber == 5){
            clubName.setText("ARSENAL");
            clubLogoImageView.setImage(new Image(getClass().getResourceAsStream("arsenal.png")));
        }
    }


}

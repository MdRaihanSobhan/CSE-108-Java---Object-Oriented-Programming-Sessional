package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class searchPlayersController implements Initializable{
    public static int clubNumber = 0 ;

    public searchPlayersController () throws Exception{

    }
    private Main main;
    private Stage searchStage;

    public void setMain(Main main) {
        this.main = main;
    }

    public void setSearchStage(Stage searchStage) {
        this.searchStage = searchStage;
    }

    public static int getClubNumber() {
        return clubNumber;
    }

    public static void setClubNumber(int clubNumber) {
        searchPlayersController.clubNumber = clubNumber;
    }

    public FileManager objectOfFile = new FileManager();
    public List<Player> playerList = FileManager.playerList;

    public Main getMain(Main main) {
        return main;
    }

    @FXML
    private Button showMaximumAgeButton;

    @FXML
    private Button showMaximumHeightButton;

    @FXML
    private Button showMaximumSalaryButton;

    @FXML
    private TextField playerNameText;

    @FXML
    private Button searchByPlayersNameButton;

    @FXML
    private TextField lowerLimitText;

    @FXML
    private TextField upperLimitText;

    @FXML
    private Button searchBySalaryRangeButton;

    @FXML
    private Label clubName;

    @FXML
    private MenuItem menuButton1_option1;

    @FXML
    private Button logOutButton;

    @FXML
    private MenuItem menuButton1_option2;

    @FXML
    private MenuItem menuButton1_option3;

    @FXML
    private MenuItem menuButton1_option4;

    @FXML
    private Button homeNavButton;

    @FXML
    private Button transferNavButton;

    @FXML
    private ImageView clubLogoView;

    @FXML
    void GoToHome(ActionEvent event) {
        System.out.println(" homeNavButton has been Pressed ");
        try {
            main.showHomeMenu();
        }catch (Exception e){
            System.out.println(" Exception in SearchPlayers Menu, homeNavMenu Button " + e);
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

    // searching countrywise player count


    void goToShowPlayersCountry() {

        showPlayerListController.setPlayerState(4);
        System.out.println("playerState set to 4 ");
        System.out.println(" SearchByNation has been Activated ");

        try {
            main.showPlayersMenu();
        }catch (Exception e){
            System.out.println(" Exception in SearchPlayers Menu, SearchByNation MenuButton " + e);
        }
    }

    @FXML
    void goToShowPlayers_Country_1(ActionEvent event) {
        showPlayerListController.setCountryName("Belgium");
        goToShowPlayersCountry();
    }

    @FXML
    void goToShowPlayers_Country_2(ActionEvent event) {
        showPlayerListController.setCountryName("Brazil");
        goToShowPlayersCountry();
    }

    @FXML
    void goToShowPlayers_Country_3(ActionEvent event) {
        showPlayerListController.setCountryName("Egypt");
        goToShowPlayersCountry();
    }

    @FXML
    void goToShowPlayers_Country_4(ActionEvent event) {
        showPlayerListController.setCountryName("England");
        goToShowPlayersCountry();
    }

    @FXML
    void goToShowPlayers_Country_5(ActionEvent event) {
        showPlayerListController.setCountryName("France");
        goToShowPlayersCountry();
    }

    @FXML
    void goToShowPlayers_Country_6(ActionEvent event) {
        showPlayerListController.setCountryName("Gabon");
        goToShowPlayersCountry();
    }

    @FXML
    void goToShowPlayers_Country_7(ActionEvent event) {
        showPlayerListController.setCountryName("Germany");
        goToShowPlayersCountry();
    }

    @FXML
    void goToShowPlayers_Country_8(ActionEvent event) {
        showPlayerListController.setCountryName("Ghana");
        goToShowPlayersCountry();
    }

    @FXML
    void goToShowPlayers_Country_9(ActionEvent event) {
        showPlayerListController.setCountryName("Italy");
        goToShowPlayersCountry();
    }

    @FXML
    void goToShowPlayers_Country_10(ActionEvent event) {
        showPlayerListController.setCountryName("Netherlands");
        goToShowPlayersCountry();
    }

    @FXML
    void goToShowPlayers_Country_11(ActionEvent event) {
        showPlayerListController.setCountryName("Portugal");
        goToShowPlayersCountry();
    }

    @FXML
    void goToShowPlayers_Country_12(ActionEvent event) {
        showPlayerListController.setCountryName("Senagal");
        goToShowPlayersCountry();
    }

    @FXML
    void goToShowPlayers_Country_13(ActionEvent event) {
        showPlayerListController.setCountryName("Spain");
        goToShowPlayersCountry();
    }

    @FXML
    void goToShowPlayers_Country_14(ActionEvent event) {
        showPlayerListController.setCountryName("Switzerland");
        goToShowPlayersCountry();
    }

    @FXML
    void goToShowPlayers_Country_15(ActionEvent event) {
        showPlayerListController.setCountryName("Uruguay");
        goToShowPlayersCountry();
    }

    // Searching players by position in a club

    void goToShowPlayersPosition() {

        showPlayerListController.setPlayerState(3);
        System.out.println("playerState set to 3 ");
        System.out.println(" SearchByPosition has been Activated ");

        try {
            main.showPlayersMenu();
        }catch (Exception e){
            System.out.println(" Exception in SearchPlayers Menu, SearchByPostion MenuButton " + e);
        }
    }

    @FXML
    void goToShowPlayersPosition1(ActionEvent event) {
        showPlayerListController.setPositionName("Goalkeeper");
        goToShowPlayersPosition();
    }

    @FXML
    void goToShowPlayersPosition2(ActionEvent event) {
        showPlayerListController.setPositionName("Defender");
        goToShowPlayersPosition();
    }

    @FXML
    void goToShowPlayersPosition3(ActionEvent event) {
        showPlayerListController.setPositionName("Midfielder");
        goToShowPlayersPosition();
    }

    @FXML
    void goToShowPlayersPosition4(ActionEvent event) {
        showPlayerListController.setPositionName("Forward");
        goToShowPlayersPosition();
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
    void searchByPlayersName(ActionEvent event) {
        showPlayerListController.setPlayerState(2);
        showPlayerListController.setPlayerName(playerNameText.getText());

        System.out.println("playerState set to 2 ");
        System.out.println(" SearchByName has been Activated ");

        try {
            main.showPlayersMenu();
        }catch (Exception e){
            System.out.println(" Exception in SearchPlayers Menu, SearchByName Button " + e);
        }
    }

    @FXML
    void searchBySalaryRange(ActionEvent event) {
        showPlayerListController.setPlayerState(5);
        System.out.println("playerState has been set to 5 ");
        System.out.println(" SearchBySalaryActivated ");

        showPlayerListController.setLowerLimitSalary(Integer.parseInt(lowerLimitText.getText()));
        showPlayerListController.setUpperLimitSalary(Integer.parseInt(upperLimitText.getText()));

        try {
            main.showPlayersMenu();
        }catch (Exception e){
            System.out.println(" Exception in SearchPlayers Menu, SearchBySalary MenuButton " + e);
        }
    }

    @FXML
    void showMaximumAge(ActionEvent event) {
        System.out.println(" ShowMaximumAge has been Pressed ");

        showResultController.setOptionNumber(1); ;
        System.out.println("Option number 1");

        try {
            main.showResultMenu();
        } catch (Exception e) {
            System.out.println(" Exception in SearchPlayers Menu, showMaxAge  Button " + e);
        }
    }

    @FXML
    void showMaximumHeight(ActionEvent event) {
        System.out.println(" ShowMaximumHeight has been Pressed ");
        showResultController.setOptionNumber(2); ;
        System.out.println("Option number 2");

        try {
            main.showResultMenu();
        } catch (Exception e) {
            System.out.println(" Exception in SearchPlayers Menu, showMaxHeight  Button " + e);
        }
    }

    @FXML
    void showMaximumSalary(ActionEvent event) {

        System.out.println(" ShowMaximumSalary has been Pressed ");
        showResultController.setOptionNumber(3); ;
        System.out.println("Option number 3");
        try {
            main.showResultMenu();
        } catch (Exception e) {
            System.out.println(" Exception in SearchPlayers Menu, showMaxSalary Button " + e);
        }
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

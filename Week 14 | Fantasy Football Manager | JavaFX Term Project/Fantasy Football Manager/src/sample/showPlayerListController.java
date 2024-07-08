package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class showPlayerListController implements Initializable {

    public static int playerState = 0;
    public static String playerName = "";
    public static String positionName = "";
    public static String countryName = "";
    public static int lowerLimitSalary = 0 ;
    public static int upperLimitSalary = 0 ;

    public showPlayerListController () throws Exception{

    }

    public FileManager objectFile = new FileManager();
    public List<Player> playerList = FileManager.playerList;

    public static int getLowerLimitSalary() {
        return lowerLimitSalary;
    }

    public static String getCountryName() {
        return countryName;
    }

    public static void setCountryName(String countryName) {
        showPlayerListController.countryName = countryName;
    }

    public static int getUpperLimitSalary() {
        return upperLimitSalary;
    }

    public static String getPositionName() {
        return positionName;
    }

    public static void setPositionName(String positionName) {
        showPlayerListController.positionName = positionName;
    }

    public static String getPlayerName() {
        return playerName;
    }

    public static void setPlayerName(String playerName) {
        showPlayerListController.playerName = playerName;
    }

    public static void setUpperLimitSalary(int upperLimitSalary) {
        showPlayerListController.upperLimitSalary = upperLimitSalary;
    }

    public static void setLowerLimitSalary(int lowerLimitSalary) {
        showPlayerListController.lowerLimitSalary = lowerLimitSalary;
    }

    public static int getPlayerState() {
        return playerState;
    }

    public static void setPlayerState(int playerState) {
        showPlayerListController.playerState = playerState;
    }

    public static int clubNumber = 0 ;
    private Stage stage;
    private Main main;

    public Main getMain(Main main) {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public static int getClubNumber() {
        return clubNumber;
    }


    public static void setClubNumber(int clubNumber) {
        showPlayerListController.clubNumber = clubNumber;
    }


    @FXML
    private ImageView clubLogoImageView;

    @FXML
    private Label clubName;

    @FXML
    private Button logOutButton;

    @FXML
    private TableView showPlayersTableView;

    @FXML
    private TableColumn<Player, String> nameColumn;

    @FXML
    private TableColumn<Player, String> countryColumn;

    @FXML
    private TableColumn<Player, String> ageColumn;

    @FXML
    private TableColumn<Player, String> heightColumn;

    @FXML
    private TableColumn<Player, String> positionColumn;

    @FXML
    private TableColumn<Player, String> jerseyNumberColumn;

    @FXML
    private TableColumn<Player, String> weeklySalaryColumn;


    @FXML
    private Button back;

    @FXML
    private Button showPlayersButton;

    @FXML
    private Label promptLabel;

    @FXML
    private Label migratedNameLabel;

    @FXML
    private Button homeNavButton;

    @FXML
    private Button searchNavButton;

    @FXML
    private Button transferNavButton;

    void setColumnsTable(){
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        heightColumn.setCellValueFactory(new PropertyValueFactory<>("height"));
        positionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));
        jerseyNumberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
        weeklySalaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));
    }

    @FXML
    void GoBackToSearch(ActionEvent event) {
        System.out.println(" Button Pressed ");

        try {
            if(playerState==1)
                main.showHomeMenu();
            else
                main.showSearchPlayerMenu();
        }catch (Exception e){
            System.out.println(" Exception in Show Players, Back Button " + e);
        }
    }

    @FXML
    void GoToHome(ActionEvent event) {
        System.out.println(" Home Nav Button Pressed ");

        try {
            main.showHomeMenu();
        }catch (Exception e){
            System.out.println(" Exception in ShowPlayers , Home Nav Button " + e);
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
    void showPlayers(ActionEvent event) throws Exception {
        setColumnsTable();

        if(playerState == 1){
            ObservableList<NewPlayer> resultItems = SearchPlayer.showAllPlayers(playerList,clubName.getText());
            showPlayersTableView.setItems(resultItems);

        }
        else if(playerState == 2){

            promptLabel.setText("Player to be searched : ");
            promptLabel.setVisible(true);
            migratedNameLabel.setText(playerName);
            migratedNameLabel.setVisible(true);

            ObservableList<NewPlayer> result = SearchPlayer.searchByPlayerName(playerList,playerName);
            showPlayersTableView.setItems(result);

        }
        else if(playerState == 3){

            promptLabel.setText("Position to be searched : ");
            promptLabel.setVisible(true);
            migratedNameLabel.setText(positionName);
            migratedNameLabel.setVisible(true);

            ObservableList<NewPlayer> result = SearchPlayer.searchByPosition(playerList, clubName.getText(), positionName);
            showPlayersTableView.setItems(result);

        }

        else if(playerState == 4){

            promptLabel.setText("Nation to be searched : ");
            promptLabel.setVisible(true);
            migratedNameLabel.setText(countryName);
            migratedNameLabel.setVisible(true);

            ObservableList<NewPlayer> result = SearchPlayer.searchByCountryName(playerList, clubName.getText(), countryName);
            showPlayersTableView.setItems(result);

        }

        else if(playerState == 5){

            promptLabel.setText("Salary Range : ");
            promptLabel.setVisible(true);

            ObservableList<NewPlayer> result = SearchPlayer.searchBySalaryRange
                    (playerList,clubName.getText(),lowerLimitSalary,upperLimitSalary);
            showPlayersTableView.setItems(result);

        }
    }

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

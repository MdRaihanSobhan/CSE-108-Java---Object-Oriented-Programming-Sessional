package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class showResultController implements Initializable{
    public static int clubNumber = 0 ;
    public static int optionNumber=0;
    public Stage stage;
    public Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public static int getOptionNumber() {
        return optionNumber;
    }

    public showResultController() throws Exception{

    }

    public Main getMain(Main main) {
        return main;
    }

    public static void setOptionNumber(int optionNumber) {
        showResultController.optionNumber = optionNumber;
    }

    public FileManager obj = new FileManager();
    public List<Player> playerList = FileManager.playerList;

    public static int getClubNumber() {
        return clubNumber;
    }

    public static void setClubNumber(int clubNumber) {
        showResultController.clubNumber = clubNumber;
    }


    @FXML
    private ImageView clubLogoImageView;

    @FXML
    private Label clubNameText;

    @FXML
    private Button backButton;

    @FXML
    private Button logOutButton;

    @FXML
    private Button showResultButton;

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
    private Label optionNameVariable;

    @FXML
    private Button homeNavButton;

    @FXML
    private Button transferNavButton;

    @FXML
    private Button searchNavButton;



    @FXML
    void GoBackToSearch(ActionEvent event) {
        System.out.println(" Back or SearchNav Button has been Pressed ");

        try {
            main.showSearchPlayerMenu();
        }catch (Exception e){
            System.out.println(" Exception in ShowMaxAge Menu, SearchPlayersNavButton " + e);
        }
    }

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
    void GoToHome(ActionEvent event) {
        System.out.println(" Home Navigation Button has been Pressed ");

        try {
            main.showHomeMenu();
        }catch (Exception e){
            System.out.println(" Exception in ShowMaxAge , Home Nav Button " + e);
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
            System.out.println(" Exception in ShowTotalSalary Logout Button " + e);
        }
    }

    @FXML
    void showResult(ActionEvent event) throws Exception{
        setColumnsTable();
        if(optionNumber == 1) {
            ObservableList<NewPlayer> result = Club.getMaxAgePlayer(playerList, clubNameText.getText());
            showPlayersTableView.setItems(result);
        }
        else if(optionNumber == 2) {
            ObservableList<NewPlayer> result = Club.getMaxHeightPlayer(playerList, clubNameText.getText());
            showPlayersTableView.setItems(result);
        }
        else if(optionNumber == 3) {
            ObservableList<NewPlayer> result = Club.getMaxSalaryPlayer(playerList, clubNameText.getText());
            showPlayersTableView.setItems(result);
        }

    }

    public void initialize(URL url, ResourceBundle resourceBundle) {

        //clubNumbers

        if(clubNumber == 1){
            clubNameText.setText("CHELSEA");
            clubLogoImageView.setImage(new Image(getClass().getResourceAsStream("chelsea.png")));
        }
        else if(clubNumber == 2){
            clubNameText.setText("MANCHESTER UNITED");
            clubLogoImageView.setImage(new Image(getClass().getResourceAsStream("manutd.png")));
        }
        else if(clubNumber == 3){
            clubNameText.setText("MANCHESTER CITY");
            clubLogoImageView.setImage(new Image(getClass().getResourceAsStream("mancity2.png")));
        }
        else if(clubNumber == 4){
            clubNameText.setText("LIVERPOOL");
            clubLogoImageView.setImage(new Image(getClass().getResourceAsStream("liverpool.png")));
        }
        else if(clubNumber == 5){
            clubNameText.setText("ARSENAL");
            clubLogoImageView.setImage(new Image(getClass().getResourceAsStream("arsenal.png")));
        }

        // option NUmbers

        if(optionNumber == 1){
            optionNameVariable.setText(" Age");
        }
        else if(optionNumber == 2){
            optionNameVariable.setText(" Height");
        }
        else if(optionNumber == 3){
            optionNameVariable.setText(" Salary");
        }
    }



}

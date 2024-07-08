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

import java.math.BigDecimal;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class showTotalSalaryOfClubController implements Initializable{
    public static int clubNumber = 0 ;
    private Stage stage;
    private Main main;

    public FileManager objectFile = new FileManager();
    public List<Player> playerList = FileManager.playerList;

    public Main getMain(Main main) {
        return main;
    }

    public showTotalSalaryOfClubController() throws Exception {
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public static int getClubNumber() {
        return clubNumber;
    }

    public static void setClubNumber(int clubNumber) {
        showTotalSalaryOfClubController.clubNumber = clubNumber;
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
    private Button showSalaryButton;

    @FXML
    private Label promptTextLabel;

    @FXML
    private Label clubNameViewTable;

    @FXML
    private Label totalSalaryView;

    @FXML
    private Button homeNavButton;

    @FXML
    private Button searchNavButton;

    @FXML
    private Button transferNavButton;

    @FXML
    void GoBackToSearch(ActionEvent event) {
        System.out.println(" Button has been Pressed ");

        try {
            main.showSearchPlayerMenu();
        }catch (Exception e){
            System.out.println(" Exception in ShowTotalSalary Menu, Back " + e);
        }
    }

    @FXML
    void GoToHome(ActionEvent event) {
        System.out.println(" Home Navigation Button has been Pressed ");

        try {
            main.showHomeMenu();
        }catch (Exception e){
            System.out.println(" Exception in ShowTotalSalary , Home Nav Button " + e);
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
    void backToHome(ActionEvent event) {
        System.out.println(" Home Navigation Button has been Pressed ");

        try {
            main.showHomeMenu();
        }catch (Exception e){
            System.out.println(" Exception in ShowTotalSalary , Home Nav Button " + e);
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
    void showSalary(ActionEvent event) {
        double yearlySalaryResult = 0;
        yearlySalaryResult = Club.getTotalYearlySalary(playerList,clubName.getText());
        int yearlySalaryResultInt = (int) yearlySalaryResult;

        promptTextLabel.setText(" Total Yearly Salary for");
        clubNameViewTable.setText(clubName.getText());

        totalSalaryView.setText(String.valueOf(BigDecimal.valueOf(yearlySalaryResultInt)) + "USD " );
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

package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class logInPageController {



    private Main main;
    private Stage logInStage;
    private Club club;

    public logInPageController() throws Exception {

    }

    public void setLogInStage(Stage logInStage) {
        this.logInStage = logInStage;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private Button logInButton;

    @FXML
    private TextField nameOfTheClub;

    @FXML
    private PasswordField passwordText;


    void setNumber (int temp){
        homeMenuController.clubNumber=temp;
        searchPlayersController.clubNumber=temp;
        showCountryWisePlayerCountController.clubNumber=temp;
        showPlayerListController.clubNumber=temp;
        showTotalSalaryOfClubController.clubNumber=temp;
        showResultController.clubNumber=temp;
    }

    @FXML
    void LogIn(ActionEvent event) throws Exception {

        if (nameOfTheClub.getText().equalsIgnoreCase("Chelsea")){
            System.out.println("Log IN with Chelsea");
            this.setNumber(1);


            System.out.println("Number 1 set");
            main.showHomeMenu();
            // main.showSearchPlayerMenu();
        }

        else if(nameOfTheClub.getText().equalsIgnoreCase("Manchester United")){
            this.setNumber(2);

            main.showHomeMenu();
        }

        else if(nameOfTheClub.getText().equalsIgnoreCase("Manchester City")){
            this.setNumber(3);

            main.showHomeMenu();
        }

        else if(nameOfTheClub.getText().equalsIgnoreCase("Liverpool")){
            this.setNumber(4);

            main.showHomeMenu();
        }

        else if(nameOfTheClub.getText().equalsIgnoreCase("Arsenal")){
            this.setNumber(5);

            main.showHomeMenu();
        }


    }

}


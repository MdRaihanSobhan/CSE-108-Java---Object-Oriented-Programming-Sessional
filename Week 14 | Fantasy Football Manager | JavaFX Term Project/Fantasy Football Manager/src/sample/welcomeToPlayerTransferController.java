package sample;


import javafx.beans.value.ChangeListener;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import server.Client;


public class welcomeToPlayerTransferController {

    private Client client ;
    private Stage stage ;
    private Main main;


    public Client getClient() {return client ;}
    public void setStage(Stage stage) {this.stage = stage ;}
    public void setMain(Main main) {this.main = main ;}


    @FXML
    private Button backButton;

    @FXML
    private Button logintoTransferButton;

    @FXML
    void goBack(ActionEvent event) throws Exception {
        main.showHomeMenu();

    }

    String setClub(){
        String name;
        int temp = homeMenuController.clubNumber;
        if(temp==1){
                name = "Chelsea";
        }
        else if(temp==2){
            name="Manchester United";
        }
        else  if(temp==3){
            name="Manchester City";
        }
        else if(temp==4){
            name="Liverpool";
        }
        else if(temp==5) {
            name = "Arsenal";
        }
        else name= "Club";

        return name;
    }

    @FXML
    void loginTransferAttempt(ActionEvent event) throws Exception{
        String serverAddress = "127.0.0.1";
        int serverPort = 55555;
        client = new Client(serverAddress, serverPort, this.setClub(), this);
    }

    public void showTransferHomeMenu() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("showTransfer.fxml"));
        Parent root = loader.load();

        // Loading the controller
        showTransferController controller = loader.getController();
        controller.setMain(this);
        controller.setStage(stage);
        controller.setClient(client);
        controller.setClubName(client.getClub().getName());


        // Set the primary stage
        stage.setTitle("TransferHomePage");
        stage.setScene(new Scene(root));
        stage.show();
    }

}

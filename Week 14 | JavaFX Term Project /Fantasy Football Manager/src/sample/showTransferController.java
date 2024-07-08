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
import server.Client;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class showTransferController implements Initializable {

    public static Main mainObject;

    private Client client;
    private welcomeToPlayerTransferController main;
    private Stage stage;
    public void setMain(welcomeToPlayerTransferController main) {
        this.main = main;
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public void setClient(Client client) {
        this.client=client;
    }
    public Client getClient() {
        return client;
    }

    public void setClubName(String name) {
        clubName.setText(name.toUpperCase(Locale.ROOT));
    }

    @FXML
    private Button homeNavButton;

    @FXML
    private Button searchNavButton;

    @FXML
    private Button transferNavButton;

    @FXML
    private ImageView clubLogoImageView;

    @FXML
    private Label clubName;

    @FXML
    private Button logOutButton;

    @FXML
    private Button buyButtobn;

    @FXML
    private Button sellButton;

    @FXML
    void GoBackToSearch(ActionEvent event) throws Exception{
        mainObject.showSearchPlayerMenu();
    }

    @FXML
    void GoToHome(ActionEvent event) throws Exception{
        mainObject.showHomeMenu();
    }

    @FXML
    void GoToTransfer(ActionEvent event) throws Exception{
        try {
            main.showTransferHomeMenu();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    void buyPlayerAction(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("buyFromMarket.fxml"));
            Parent root = loader.load();

            // Loading the controller
            buyFromMarketController controller = loader.getController();
            controller.setStage(stage);
            controller.setHomePage(this);
            controller.getPlayerListToBuy();

            // Set the primary stage
            stage.setTitle("Transfer Buy Page");
            stage.setScene(new Scene(root));
            stage.show();
        }catch( Exception e){
            System.out.println("Exception in buy player in Homepage" + e);
        }
    }

    @FXML
    void logout(ActionEvent event) throws Exception{
        mainObject.showTransferMenu();

    }

    @FXML
    void sellPlayerAction(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sellToMarket.fxml"));
        Parent root = loader.load();

        // Loading the controller
        sellToMarketController controller = loader.getController();
        controller.setStage(stage);
        controller.setHomePage(this);
        controller.getCurrentPlayerList();

        // Set the primary stage
        stage.setTitle("Transfer Sell Page");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(homeMenuController.clubNumber == 1){
            clubLogoImageView.setImage(new Image(getClass().getResourceAsStream("chelsea.png")));
        }
        else if(homeMenuController.clubNumber == 2){
            clubLogoImageView.setImage(new Image(getClass().getResourceAsStream("manutd.png")));
        }
        else if(homeMenuController.clubNumber == 3){
            clubLogoImageView.setImage(new Image(getClass().getResourceAsStream("mancity2.png")));
        }
        else if(homeMenuController.clubNumber == 4){
            clubLogoImageView.setImage(new Image(getClass().getResourceAsStream("liverpool.png")));
        }
        else if(homeMenuController.clubNumber == 5){
            clubLogoImageView.setImage(new Image(getClass().getResourceAsStream("arsenal.png")));
        }
    }

}

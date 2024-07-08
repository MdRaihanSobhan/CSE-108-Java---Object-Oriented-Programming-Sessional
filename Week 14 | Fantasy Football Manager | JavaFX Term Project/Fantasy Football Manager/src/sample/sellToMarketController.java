package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class sellToMarketController {

    private showTransferController transferHomePage;
    private Stage stage;
    private List<Player> CurrentPlayerlist;
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public void setHomePage(showTransferController homePage) {
        this.transferHomePage = homePage;
    }

    @FXML
    private GridPane gridCard;

    @FXML
    private Button backButton;

    @FXML
    void back(ActionEvent event)  {
        try {
            transferHomePage.GoToTransfer(event);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void getCurrentPlayerList(){
        this.CurrentPlayerlist= new ArrayList<>();
        CurrentPlayerlist = transferHomePage.getClient().getClub().getPlayerList();
        System.out.println("Got exception in this line 48");
        gridCard.getChildren().clear();
        int column=1,row=1;
        try{
            column=0;
            for(Player p: CurrentPlayerlist){
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("displayPlayerInfo.fxml"));
                AnchorPane anchorpane=loader.load();
                System.out.println("Got exception in this line 57");
                displayPlayerInfoController controller = loader.getController();
                controller.setTransferHome(transferHomePage);
                System.out.println("loader loaded");
                controller.setToSell(p);
                System.out.println("sold player");

                System.out.println("Got exception in this line 61");
                gridCard.add(anchorpane,column,row++);

                gridCard.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridCard.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridCard.setMaxWidth(Region.USE_COMPUTED_SIZE);

                gridCard.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridCard.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridCard.setMaxHeight(Region.USE_COMPUTED_SIZE);

                GridPane.setMargin(anchorpane,new Insets(10));
            }
        }catch(Exception e){
            System.out.println(" Exception in showing player loop  line 66  " + e);
        }
    }

}

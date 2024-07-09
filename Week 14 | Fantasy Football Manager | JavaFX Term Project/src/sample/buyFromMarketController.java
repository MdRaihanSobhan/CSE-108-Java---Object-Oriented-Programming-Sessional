package sample;

import javafx.fxml.FXML;
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


public class buyFromMarketController {


    private showTransferController transferHome;
    private Stage stage;
    private List<Player> PlayerListToBuy;
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public void setHomePage(showTransferController transferHome) {
        this.transferHome = transferHome;
    }

    @FXML
    private GridPane gridCard;

    @FXML
    private Button backButton;

    @FXML
    void back(ActionEvent event) {
        try {
            transferHome.GoToTransfer(event);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void getPlayerListToBuy(){
        PlayerListToBuy = transferHome.getClient().getClub().getPlayersToBuyList();
        gridCard.getChildren().clear();
        int column=1,row=1;
        try{
            column=0;
            for(Player p: PlayerListToBuy){

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("displayPlayerInfo.fxml"));
                AnchorPane anchorpane=loader.load();

                displayPlayerInfoController controller = loader.getController();
                controller.setToBuy(p);
                controller.setTransferHome(transferHome);

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
            System.out.println(" Exception in showing player loop" + e);
        }
    }

}

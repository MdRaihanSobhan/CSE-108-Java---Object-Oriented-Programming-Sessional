package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage stage;
    private Club club;


    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        primaryStage.setResizable(false);
        showLoginMenu();
    }

    //throws IOException

    public void showHomeMenu()throws IOException  {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("homeMenu.fxml"));

        System.out.println("homeMenu gotten");

        Parent root = loader.load();

        System.out.println("homeMenu loaded");

        // Loading the controller
        homeMenuController controller = loader.getController();
        controller.setMain(this);
        controller.setHomeStage(stage);

        // Set the primary stage
        stage.setTitle("Home");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void showSearchPlayerMenu() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("searchPlayers.fxml"));
        Parent root = loader.load();


        // Loading the controller
        searchPlayersController controller = loader.getController();
        controller.setMain(this);
        controller.setSearchStage(stage);

        // Set the primary stage
        stage.setTitle("Search");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void  showTransferMenu() throws Exception {
        // XML Loading using FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("welcomeToPlayerTransfer.fxml"));
        Parent root = loader.load();

        // Loading the controller
        welcomeToPlayerTransferController controller = loader.getController();
        controller.setMain(this);
        controller.setStage(stage);

        // Set the primary stage
        stage.setTitle("Transfer Market");
        stage.setScene(new Scene(root));
        stage.show();
    }





    public void  showLoginMenu() throws Exception {
        // XML Loading using FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("logInPage.fxml"));
        Parent root = loader.load();

        System.out.println("login loaded");

        // Loading the controller
        logInPageController controller = loader.getController();
        controller.setMain(this);
        controller.setLogInStage(stage);

        // Set the primary stage
        stage.setTitle("Login");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void showPlayersMenu() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("showPlayerList.fxml"));
        Parent root = loader.load();


        // Loading the controller
        showPlayerListController controller = loader.getController();
        controller.setMain(this);
        controller.setStage(stage);

        // Set the primary stage
        stage.setTitle("Home");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void showCountryWisePlayerCountMenu() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("showCountryWisePlayerCount.fxml"));
        Parent root = loader.load();


        // Loading the controller
        showCountryWisePlayerCountController controller = loader.getController();
        controller.setMain(this);
        controller.setStage(stage);

        // Set the primary stage
        stage.setTitle("Login");
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void showTotalSalaryMenu() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("showTotalSalaryOfClub.fxml"));
        Parent root = loader.load();


        // Loading the controller
        showTotalSalaryOfClubController controller = loader.getController();
        controller.setMain(this);
        controller.setStage(stage);

        // Set the primary stage
        stage.setTitle("Login");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void showResultMenu() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("showResult.fxml"));
        Parent root = loader.load();


        // Loading the controller
        showResultController controller = loader.getController();
        controller.setMain(this);
        controller.setStage(stage);

        // Set the primary stage
        stage.setTitle("Showing Maximum Results");
        stage.setScene(new Scene(root));
        stage.show();
    }




    public static void main(String[] args) throws Exception {
        FileManager.readFromFile();
        launch(args);
    }
}
